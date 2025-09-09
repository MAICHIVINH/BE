package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admins, Integer> {
    List<Admins> findByAdminUserNameContainingIgnoreCase(String keyword);
    List<Admins> findByAdminStatusTrue();
    List<Admins> findByIsDeletedFalse();
    Optional<Admins> findByAdminIdAndIsDeletedFalse(Integer id);

}
