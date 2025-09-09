package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.entities.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Roles> getAllRole();

    Page<Roles> getRolePaging(Pageable pageable);

    Optional<Roles> getRoleById(Integer id);

    Roles createRole(Roles role);

    Roles updateRole(Integer id, Roles role);

    void softDeleteRole(Integer id);

    void hardDeleteRole(Integer id);
}
