package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    List<Roles> findByIsDeletedFalse();
}
