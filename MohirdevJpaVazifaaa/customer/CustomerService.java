package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.customer;
import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public List<Customer> findByCreatedDate(LocalDate date) {
        return customerRepository.findByCreatedDate(date);
    }

    public List<Employee> findBestEmployee() {
        return customerRepository.findBestEmployee();
    }

    public List<Employee> getBestThree() {
        List<Employee> bestEmployees = customerRepository.findBestEmployee();
        return customerRepository.findBestEmployee();

    }
    public long getCountOfNewCustomersInLastMonth() {
        LocalDate oyningBoshlangichi = LocalDate.now().withDayOfMonth(1);
        LocalDate oyningOxirgiKuni = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
        return customerRepository.countByCreatedDateBetween(oyningBoshlangichi, oyningOxirgiKuni);
    }

}