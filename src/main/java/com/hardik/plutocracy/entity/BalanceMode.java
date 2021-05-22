package com.hardik.plutocracy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "balance_modes")
public class BalanceMode implements Serializable {

	private static final long serialVersionUID = -6355462386694894438L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private UUID id;

	@Column(name = "total_balance_id", nullable = true)
	private UUID totalBalanceId;

	@Hidden
	@Exclude
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "total_balance_id", nullable = true, insertable = false, updatable = false)
	private TotalBalance totalBalance;

	@Column(name = "mode_type", nullable = false)
	private String modeType;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "value", nullable = false)
	private Double value;

	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "balanceMode", fetch = FetchType.LAZY)
	private Set<CompletedTicket> completedTickets;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "balanceMode", fetch = FetchType.LAZY)
	private Set<FutureTicket> futureTickets;

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
