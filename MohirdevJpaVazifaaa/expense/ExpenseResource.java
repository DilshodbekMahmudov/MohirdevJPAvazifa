package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/expense")
public class ExpenseResource {

    private final ExpenseService expenseService;

    public ExpenseResource(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expenses")
    public ResponseEntity create(@RequestBody Expense expense){
        Expense result= expenseService.save(expense);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/expenses")
    public ResponseEntity update(@RequestBody Expense expense){
        Expense add = expenseService.save(expense);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Expense> result=expenseService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/expenses/all")
    public ResponseEntity findAll(){
        List<Expense> expenses = expenseService.findAll();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/expenses/paging")
    public ResponseEntity findAllPaging(Pageable pageable){
        Page<Expense> result=expenseService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/expenses/most-expense")
    public ResponseEntity getMostExpensiveExpenseType(){
        List<Object[]> result=expenseService.getMostExpensiveExpenseType();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/expenses/to-employee")
    public ResponseEntity getMostExpensedEmployee(){
        List<Object[]> result=expenseService.findEmployeeWithMostExpenses();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/expenses/last-month-registered")
    public ResponseEntity<Long> getLastMonthRegistered() {
        long expensesCount = expenseService.getCountOfNewExpensesInLastMonth();
        return ResponseEntity.ok().body(expensesCount);
    }

    @GetMapping("/expenses/by-type")
    public ResponseEntity<?> getByAdType(){
        List<?> result = expenseService.getByAdType();
        return ResponseEntity.ok(result);
    }

}
