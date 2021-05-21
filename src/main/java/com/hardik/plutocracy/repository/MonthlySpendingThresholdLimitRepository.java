package com.hardik.plutocracy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.plutocracy.entity.MonthlySpendingThresholdLimit;

@Repository
public interface MonthlySpendingThresholdLimitRepository extends JpaRepository<MonthlySpendingThresholdLimit, Integer> {

}
