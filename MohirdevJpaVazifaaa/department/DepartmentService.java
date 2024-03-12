package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.department;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public Optional<Department> findById(Long id){
        Optional<Department> department=departmentRepository.findById(id);
        return department;
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }

}
