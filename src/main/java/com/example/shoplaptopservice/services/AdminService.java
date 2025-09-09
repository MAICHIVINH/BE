package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Admins;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    List<Admins> getAllAdmin();

    Page<Admins> getAdminPaging(Pageable pageable);

    Optional<Admins> getAdminById(Integer id);

    Admins createAdmin(Admins admin, MultipartFile file);

    Admins updateAdmin(Integer id, Admins admin, MultipartFile file);

    // Xóa ngắn (đánh dấu isDeleted = true)
    void softDeleteAdmin(Integer id);

    // Xóa hẳn khỏi DB
    void hardDeleteAdmin(Integer id);

    List<Admins> searchAdminByUsername(String keyword);

    List<Admins> getAdminByStatusTrue();
}
