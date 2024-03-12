package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee;

import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.department.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Integer countEmployeeByDepartment(Department department);

    @Query("select e from Employee e where e.age = :age")
    List<Employee> findAll(@Param("age") int age);

    Page<Employee> findAll(Pageable pageable);

}

