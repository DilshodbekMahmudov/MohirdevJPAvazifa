package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.customer;

import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByCreatedDate(LocalDate date);

    @Query("SELECT c.employee FROM Customer c " +
            "GROUP BY c.employee " +
            "ORDER BY COUNT(c.id) DESC")

    List<Employee> findBestEmployee();


    @Query("SELECT COUNT(c) FROM Customer c WHERE c.createdDate BETWEEN :boshlangichi AND :oxirgiKuni")
    long countByCreatedDateBetween(@Param("boshlangichi") LocalDate boshlangichi, @Param("oxirgiKuni") LocalDate oxirgiKuni);

    List<Customer> findByOrderByCreatedDateDesc();


}
