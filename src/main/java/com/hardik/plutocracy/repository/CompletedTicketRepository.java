package com.hardik.plutocracy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardik.plutocracy.entity.CompletedTicket;

@Repository
public interface CompletedTicketRepository extends JpaRepository<CompletedTicket, UUID> {

	List<CompletedTicket> findByUserIdAndCreatedAtBetween(UUID userId, LocalDate startDate, LocalDate endDate);

}
