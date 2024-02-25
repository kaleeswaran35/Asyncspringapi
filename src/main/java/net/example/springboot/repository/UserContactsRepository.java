/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.repository;


import net.example.springboot.entity.UserContacts;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kalees
 */

@Repository
public interface UserContactsRepository extends JpaRepository<UserContacts, Long>  {
    
}
