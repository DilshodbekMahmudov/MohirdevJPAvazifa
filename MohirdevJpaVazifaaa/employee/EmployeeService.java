package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee;

import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.customer.Customer;
import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id){
        Optional<Employee> employee=employeeRepository.findById(id);
        return employee;
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public long getCount(){
        return employeeRepository.count();
    }

    public List<Employee> findAllByAge(int age){
        List<Employee> employees = employeeRepository.findAll(age);
        return employees;
    }

    public Page<Employee> findAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    public double getTotalSalary(){
        List<Employee> employees = employeeRepository.findAll();
        double totalSalary = employees.stream().mapToDouble(Employee ::getSalary).sum();
        return totalSalary;
    }

}
