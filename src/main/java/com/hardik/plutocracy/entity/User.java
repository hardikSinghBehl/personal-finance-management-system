package com.hardik.plutocracy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 5155736403725997140L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private UUID id;

	@Column(name = "email_id", nullable = false, unique = true, length = 50)
	private String emailId;

	@Column(name = "password", nullable = false, length = 150)
	private String password;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<CompletedTicket> completedTickets;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<FutureTicket> futureTickets;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Goal> goals;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Note> notes;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<CurrentMonthlySpendingThresholdLimit> currentMonthlySpendingThresholdLimits;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<SpendingThresholdRecord> spendingThresholdRecords;

	@PrePersist
	void onCreate() {
		this.id = UUID.randomUUID();
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
