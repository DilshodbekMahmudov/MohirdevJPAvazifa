package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee;

import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee){
        Employee result = employeeService.save(employee);
            return ResponseEntity.ok(result);
        }

    @GetMapping("/employees/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Employee> result=employeeService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }

    @GetMapping("/employees/count")
    public ResponseEntity<Long> getCount(){
        long result = employeeService.getCount();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/age")
    public ResponseEntity getAll(@RequestParam int age){
        List<Employee> employees = employeeService.findAllByAge(age);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/paging")
    public ResponseEntity findAllPaging(Pageable pageable){
        Page<Employee> result=employeeService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/total-salary")
    public double getTotalSalary(){
        return employeeService.getTotalSalary();
    }

    }
