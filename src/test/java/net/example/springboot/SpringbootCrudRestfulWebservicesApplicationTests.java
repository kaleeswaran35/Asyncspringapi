package net.example.springboot;

import net.example.springboot.entity.Users;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc

class SpringbootCrudRestfulWebservicesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getalluser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(status().isOk());
    }
}
