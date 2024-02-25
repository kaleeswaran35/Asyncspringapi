/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.example.springboot.entity.Users;
import org.springframework.stereotype.Service;

/**
 *
 * @author kalees
 */

public interface UserRepositoryService {
    
  public List<Users> get();  
    
}
