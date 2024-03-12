package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense;

import com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String adType;

    private Double adPrice;

    private String adPeriod;

    private LocalDate createdDate;

    private LocalTime localTime;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public Double getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(Double adPrice) {
        this.adPrice = adPrice;
    }

    public String getAdPeriod() {
        return adPeriod;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public void setAdPeriod(String adPeriod) {
        this.adPeriod = adPeriod;


    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
