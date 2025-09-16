package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Admins;
import com.example.shoplaptopservice.entities.Roles;
import com.example.shoplaptopservice.repositories.AdminRepository;
import com.example.shoplaptopservice.repositories.RoleRepository;
import com.example.shoplaptopservice.services.AdminService;
import com.example.shoplaptopservice.utils.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public List<Admins> getAllAdmin() {
        return adminRepository.findByIsDeletedFalse();
    }

    @Override
    public Page<Admins> getAdminPaging(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    @Override
    public Optional<Admins> getAdminById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admins createAdmin(Admins admin, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String imageUrl = cloudinaryService.uploadFile(file);
                admin.setAdminAvatar(imageUrl);
            } catch (IOException e) {
                throw new RuntimeException("Upload avatar failed: " + e.getMessage(), e);
            }
        }

        if (admin.getDeleted() == null) {
            admin.setDeleted(false);
        }

        // Gán role chắc chắn từ DB
        if (admin.getRoles() != null && admin.getRoles().getRoleId() != null) {
            Roles role = roleRepository.findById(admin.getRoles().getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            admin.setRoles(role);
        }

        return adminRepository.save(admin);
    }

    @Override
    public Admins updateAdmin(Integer id, Admins admin, MultipartFile file) {
        Admins existing = adminRepository.findByAdminIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (file != null && !file.isEmpty()) {
            try {
                String imageUrl = cloudinaryService.uploadFile(file);
                existing.setAdminAvatar(imageUrl);
            } catch (IOException e) {
                throw new RuntimeException("Upload avatar failed: " + e.getMessage(), e);
            }
        }
        existing.setAdminUserName(admin.getAdminUserName());
        existing.setAdminPassword(admin.getAdminPassword());
        existing.setAdminEmail(admin.getAdminEmail());
        existing.setAdminNumberPhone(admin.getAdminNumberPhone());
        existing.setAdminAddress(admin.getAdminAddress());
        existing.setAdminStatus(admin.getAdminStatus());


        // Gán role chắc chắn từ DB
        if (admin.getRoles() != null && admin.getRoles().getRoleId() != null) {
            Roles role = roleRepository.findById(admin.getRoles().getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            existing.setRoles(role);
        }
        return adminRepository.save(existing);
    }

    @Override
    public void softDeleteAdmin(Integer id) {
        Admins admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setDeleted(true);
        adminRepository.save(admin);
    }

    @Override
    public void hardDeleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admins> searchAdminByUsername(String keyword) {
        return adminRepository.findByAdminUserNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Admins> getAdminByStatusTrue() {
        return adminRepository.findByAdminStatusTrue();
    }
}
