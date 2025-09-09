package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Roles;
import com.example.shoplaptopservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/roles")
public class RoleController {
        @Autowired
        private RoleService roleService;

        @GetMapping("/all")
        public List<Roles> getAllRole() {
                return roleService.getAllRole();
        }

        @GetMapping("/page")
        public Page<Roles> getPagingRole(@RequestParam int page, @RequestParam int size) {
                return roleService.getRolePaging(PageRequest.of(page, size));
        }

        @GetMapping("/{id}")
        public Optional<Roles> getRoleById(@PathVariable Integer id) {
                return roleService.getRoleById(id);
        }

        @PostMapping("/add")
        public String createRole(@RequestBody Roles role) {
                roleService.createRole(role);
                return "Role created successfully!";
        }

        @PutMapping("/update/{id}")
        public String updateRole(@PathVariable Integer id, @RequestBody Roles role) {
                roleService.updateRole(id, role);
                return "Role updated successfully!";
        }

        @DeleteMapping("/soft-delete/{id}")
        public String softDeleteRole(@PathVariable Integer id) {
                roleService.softDeleteRole(id);
                return "Role soft deleted successfully!";
        }

        @DeleteMapping("/hard-delete/{id}")
        public String hardDeleteRole(@PathVariable Integer id) {
                roleService.hardDeleteRole(id);
                return "Role hard deleted successfully!";
        }
}
