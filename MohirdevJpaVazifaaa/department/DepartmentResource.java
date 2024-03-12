package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.department;
import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentResource {
    private final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public ResponseEntity create(@RequestBody Department department){
        Department add = departmentService.save(department);
        return ResponseEntity.ok(add);
    }

    @PutMapping("/department")
    public ResponseEntity update(@RequestBody Department department){
        Department add = departmentService.save(department);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Department> result=departmentService.findById(id);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/department/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }
}
