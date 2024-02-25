/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.service;

import java.util.List;
import javax.transaction.Transactional;
import net.example.springboot.entity.Users;
import net.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author kalees
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
@RefreshScope
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public List<Users> get() {
        return userRepository.findAll();   //To change body of generated methods, choose Tools | Templates.
    }

}
