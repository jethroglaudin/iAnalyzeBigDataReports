package com.iAnalyze.microservice.reportsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iAnalyze.microservice.reportsservice.model.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT u FROM Transaction u WHERE u.isFraud = 1")
    public List<Transaction> findByIsFraud();
}
