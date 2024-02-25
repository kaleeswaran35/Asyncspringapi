package net.example.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.example.springboot.entity.Users;
import net.example.springboot.exception.ResourceNotFoundException;
import net.example.springboot.repository.UserRepository;
import net.example.springboot.service.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

@Scope(value = "request")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepositoryServiceImpl userRepositoryServiceImpl;

    @Autowired
    private UserRepository userRepository;

    
    @Autowired
    RestTemplate restTemplate;

    // get all users
    /**
     *
     * @return
     */
    @GetMapping
    @Async(value = "My task executor")
    public CompletableFuture<List<Users>> getAllUsers() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        return CompletableFuture.completedFuture(userRepositoryServiceImpl.get());

    }

    @Async
    @GetMapping("/users")
    public CompletableFuture<ArrayNode> callOtherService() throws InterruptedException {
        String localSlowServiceEndpointpost = "https://dummyjson.com/products/1";
        JsonNode responseObj1 = restTemplate.getForObject(localSlowServiceEndpointpost, JsonNode.class);
        System.out.println("responseObj1" + responseObj1);
        CompletableFuture response1 = CompletableFuture.completedFuture(responseObj1);

        String localSlowServiceEndpoint = "https://dummyjson.com/products/2";
        JsonNode responseObj = restTemplate.getForObject(localSlowServiceEndpoint, JsonNode.class);
        System.out.println("responseObj" + responseObj);
        CompletableFuture response = CompletableFuture.completedFuture(responseObj);

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        jsonArray.add(responseObj1);
        jsonArray.add(responseObj);

        System.out.println(jsonArray);
        return CompletableFuture.completedFuture(jsonArray);
    }

    // get user by id
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    // create user
    @PostMapping("/createuser")
    public Users createUser(@RequestBody Users user) {
        return this.userRepository.save(user);
    }

    // update user
    @PutMapping("/{id}")
    public Users updateUser(@RequestBody Users user, @PathVariable("id") long userId) {
        Users existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable("id") long userId) {
        Users existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }


}
