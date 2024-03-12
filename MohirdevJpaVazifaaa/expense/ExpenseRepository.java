package com.MohirdevJpaVazifaaa.MohirdevJpaVazifaaa.expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT e.adType, SUM(e.adPrice) as totalCost " +
            "FROM Expense e " +
            "GROUP BY e.adType " +
            "ORDER BY totalCost DESC")
    List<Object[]> findMostExpensiveExpenseType();

    @Query("SELECT e.employee.id, e.employee.firstName, SUM(e.adPrice) as totalCost " +
            "FROM Expense e " +
            "GROUP BY e.employee.id, e.employee.firstName " +
            "ORDER BY totalCost DESC")
    List<Object[]> findEmployeeWithMostExpenses();

    long countByCreatedDateBetween(LocalDate oyningBoshlangichi, LocalDate oyningOxirgiKuni);

    @Query("SELECT e.adType, COUNT(e.id) " +
            "FROM Expense e " +
            "GROUP BY e.adType")
    List<Object[]> countExpensesByType();
}

