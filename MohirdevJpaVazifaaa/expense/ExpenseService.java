package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense save(Expense expense){
        return expenseRepository.save(expense);
    }

    public Optional<Expense> findById(Long id){
        Optional<Expense> expense=expenseRepository.findById(id);
        return expense;
    }

    public List<Expense> findAll(){
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }
    public Page<Expense> findAll(Pageable pageable){
        return expenseRepository.findAll(pageable);
    }

    public List<Object[]> getMostExpensiveExpenseType(){
        return  expenseRepository.findMostExpensiveExpenseType();
    }

    public List<Object[]> findEmployeeWithMostExpenses(){
        return expenseRepository.findEmployeeWithMostExpenses();
    }


    public long getCountOfNewExpensesInLastMonth() {
        LocalDate oyningBoshlangichi = LocalDate.now().withDayOfMonth(1);
        LocalDate oyningOxirgiKuni = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
        return expenseRepository.countByCreatedDateBetween(oyningBoshlangichi, oyningOxirgiKuni);
    }

    public List<?> getByAdType(){
        List<Object[]> result =expenseRepository.countExpensesByType();
        return expenseRepository.countExpensesByType();
    }


}

