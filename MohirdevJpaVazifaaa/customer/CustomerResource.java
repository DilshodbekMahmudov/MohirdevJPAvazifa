package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.customer;
import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity create(@RequestBody Customer customer){
        Customer add = customerService.save(customer);
        return ResponseEntity.ok(add);
    }

    @PutMapping("/customers")
    public ResponseEntity update(@RequestBody Customer customer){
        Customer add = customerService.save(customer);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Customer> result=customerService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }

    @GetMapping("/customers/all")
    public ResponseEntity findAll(){
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/customers/registered-count")
    public ResponseEntity findByCreatedDate(){
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/customers/most-registered")
    public ResponseEntity findBestEmployee(){
        List<?> customers = customerService.findBestEmployee();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/best-three")
    public ResponseEntity getBestThree(){
        List<?> customers = customerService.getBestThree();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/customers/last-month-registered")
    public ResponseEntity<Long> getLastMonthRegistered() {
        long customersCount = customerService.getCountOfNewCustomersInLastMonth();
        return ResponseEntity.ok().body(customersCount);
    }

    @GetMapping("/customer/most-created-date")
    public Map<Object, Long> getMostCreatedDate() {
        List<Customer> customers = customerService.findAll();

        Map<Object, Long> dates = customers.stream()
                .collect(Collectors.groupingBy(customer -> customer.getCreatedDate(), Collectors.counting()));

        Map.Entry<Object, Long> mostCreatedDate = dates.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        return Collections.singletonMap(mostCreatedDate.getKey(), mostCreatedDate.getValue());
    }

}
