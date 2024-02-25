/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.controller;

import java.util.List;
import net.example.springboot.entity.UserContacts;
import net.example.springboot.service.UserContactsRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kalees
 */
@RestController
@RequestMapping("/api/usercontacts")
public class UserContactsController {

    @Autowired
    private UserContactsRepositoryServiceImpl userContactsRepositoryserviceimpl;

    // get all usersContacts
    @Async
    @GetMapping("/getall")
    public List<UserContacts> getAllUsers() {
        return userContactsRepositoryserviceimpl.get();
    }

    @Async
    @PostMapping("/createusercontacts")
    public  HttpStatus createUserContacts(@Validated @RequestBody UserContacts userContacts) {
        this.userContactsRepositoryserviceimpl.save(userContacts);
        return HttpStatus.CREATED;
    }

}
