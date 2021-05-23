package com.hardik.plutocracy.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "spending_threshold_records")
public class SpendingThresholdRecord implements Serializable {

	private static final long serialVersionUID = 9034204572897473307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
	private Integer id;

	@Column(name = "user_id", nullable = true)
	private UUID userId;

	@Hidden
	@Exclude
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = true, insertable = false, updatable = false)
	private User user;

	@Column(name = "limit_value", nullable = false)
	private Double limitValue;

	@Column(name = "value_spent", nullable = false)
	private Double valueSpent;

	@Column(name = "month", nullable = false)
	private String month;

	@Column(name = "year", nullable = false)
	private String year;
}
