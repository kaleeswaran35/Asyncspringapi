package net.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.example.springboot.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
