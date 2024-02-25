/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.service;

import java.util.List;
import javax.transaction.Transactional;
import net.example.springboot.entity.UserContacts;
import net.example.springboot.entity.Users;
import net.example.springboot.repository.UserContactsRepository;
import net.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author kalees
 */
@Service
public class UserContactsRepositoryServiceImpl implements UserContactsRepositoryService {
    
    @Autowired
    UserContactsRepository userContatsRepository;
    
    
    @Transactional
    @Override
    public List<UserContacts> get(){
      return  userContatsRepository.findAll();
    }
    
    @Transactional
    @Override
    public HttpStatus save(UserContacts userContacts){
      userContatsRepository.save(userContacts);
      return HttpStatus.CREATED;
    }
}
