package com.hardik.plutocracy.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.plutocracy.entity.CurrentMonthlySpendingThresholdLimit;

@Repository
public interface CurrentMonthlySpendingThresholdLimitRepository
		extends JpaRepository<CurrentMonthlySpendingThresholdLimit, Integer> {

	Optional<CurrentMonthlySpendingThresholdLimit> findByUserId(UUID userId);

}
