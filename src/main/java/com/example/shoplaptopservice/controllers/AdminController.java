package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Admins;
import com.example.shoplaptopservice.services.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {
                "http://localhost:5173",
                "http://localhost:5174",
                "http://localhost:5175",
                "http://localhost:5176",
                "http://localhost:5177",
                "http://localhost:5178",
                "http://localhost:5179"
        },
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
        allowedHeaders = "*"
)
@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admins> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    @GetMapping("/page")
    public Page<Admins> getAdminPaging(@RequestParam int page, @RequestParam int size) {
        return adminService.getAdminPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Admins> getAdminById(@PathVariable Integer id) {
        return adminService.getAdminById(id);
    }


    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createAdmin(
            @RequestPart("admin") String adminJson,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Admins admin = mapper.readValue(adminJson, Admins.class);  // Parse chuỗi JSON thành object

            Admins saved = adminService.createAdmin(admin, file);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid JSON: " + e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAdmin(
            @PathVariable Integer id,
            @RequestPart("admin") String adminJson,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Admins admin = mapper.readValue(adminJson, Admins.class);

            Admins updated = adminService.updateAdmin(id, admin, file);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid JSON: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public String softDeleteAdmin(@PathVariable Integer id) {
        adminService.softDeleteAdmin(id);
        return "Admin soft-deleted successfully!";
    }

    @DeleteMapping("/hard-delete/{id}")
    public String hardDeleteAdmin(@PathVariable Integer id) {
        adminService.hardDeleteAdmin(id);
        return "Admin permanently deleted!";
    }

    @GetMapping("/search")
    public List<Admins> searchAdmin(@RequestParam String keyword) {
        return adminService.searchAdminByUsername(keyword);
    }

    @GetMapping("/active")
    public List<Admins> getActiveAdmin() {
        return adminService.getAdminByStatusTrue();
    }
}
