/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.service;

import java.util.List;
import net.example.springboot.entity.UserContacts;
import org.springframework.http.HttpStatus;

/**
 *
 * @author kalees
 */
public interface UserContactsRepositoryService {
    
    public List<UserContacts> get();

    /**
     *
     * @param userContacts
     * @return
     */
    public HttpStatus save(UserContacts userContacts);
}
