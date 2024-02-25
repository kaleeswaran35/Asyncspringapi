/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author kalees
 */

@Entity
@Table(name = "usercontacts")
@JsonInclude(Include.NON_NULL)
public class UserContacts implements Serializable {
   
        @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
    
        @Column(name = "phone_number")
        private Integer  phoneNumber;       
        
        
        @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name = "id", insertable = false,updatable = false)          
        @NotFound(action = NotFoundAction.IGNORE) // To remove the not found exception in postman
        @JsonIgnore // to remove null in the response
        private Users users;  
        

    public UserContacts() {
    }       
       

    public UserContacts(long id, Integer phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserContacts{" + "id=" + id + ", phoneNumber=" + phoneNumber + '}';
    }

    

          
        
    
}
