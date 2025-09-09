package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Roles;
import com.example.shoplaptopservice.repositories.RoleRepository;
import com.example.shoplaptopservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Roles> getAllRole() {
        return roleRepository.findByIsDeletedFalse();
    }

    @Override
    public Page<Roles> getRolePaging(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Optional<Roles> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Roles createRole(Roles role) {
        role.setRoleStatus(true);   // mặc định active
        role.setDeleted(false);
        return roleRepository.save(role);
    }

    @Override
    public Roles updateRole(Integer id, Roles role) {
        Roles existing = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role không tồn tại"));

        //cập nhật từng field
        existing.setRoleName(role.getRoleName());
        existing.setRoleStatus(role.getRoleStatus());
//        existing.setDeleted(role.getDeleted());
        return roleRepository.save(existing);
    }

    @Override
    public void softDeleteRole(Integer id) {
        Roles role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role không tồn tại"));

        role.setDeleted(true); // đánh dấu là đã xóa
        roleRepository.save(role);
    }

    @Override
    public void hardDeleteRole(Integer id) {
        Roles role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role không tồn tại"));

        roleRepository.delete(role); // xóa hẳn khỏi DB
    }
}
