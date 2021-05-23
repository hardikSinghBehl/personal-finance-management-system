package com.hardik.plutocracy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hardik.plutocracy.dto.response.SpendingThresholdRecordDto;
import com.hardik.plutocracy.repository.SpendingThresholdRecordRepository;
import com.hardik.plutocracy.security.utility.JwtUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpendingThresholdRecordService {

	private final SpendingThresholdRecordRepository spendingThresholdRecordRepository;
	private final JwtUtils jwtUtils;

	public ResponseEntity<List<SpendingThresholdRecordDto>> retreivePastRecords(final String token) {
		return ResponseEntity.ok(spendingThresholdRecordRepository
				.findByUserId(jwtUtils.extractUserId(token.replace("Bearer ", ""))).parallelStream()
				.map(pastSpendingRecord -> SpendingThresholdRecordDto.builder().id(pastSpendingRecord.getId())
						.limitValue(pastSpendingRecord.getLimitValue()).month(pastSpendingRecord.getMonth())
						.valueSpent(pastSpendingRecord.getValueSpent()).year(pastSpendingRecord.getYear()).build())
				.collect(Collectors.toList()));
	}

}
