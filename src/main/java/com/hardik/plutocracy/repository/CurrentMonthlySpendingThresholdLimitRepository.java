package com.hardik.plutocracy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.plutocracy.entity.CurrentMonthlySpendingThresholdLimit;

@Repository
public interface CurrentMonthlySpendingThresholdLimitRepository
		extends JpaRepository<CurrentMonthlySpendingThresholdLimit, Integer> {

}
