package com.hardik.plutocracy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "ticket_tag_mappings", uniqueConstraints = { @UniqueConstraint(columnNames = { "ticket_id", "tag_id" }) })
public class TicketTagMapping implements Serializable {

	private static final long serialVersionUID = 7485034351930195266L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "tag_id", nullable = true)
	private Integer tagId;

	@Hidden
	@Exclude
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", nullable = true, insertable = false, updatable = false)
	private Tag tag;

	@Column(name = "ticket_type", nullable = false)
	private String ticketType;

	@Column(name = "ticket_id", nullable = false)
	private UUID ticketId;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

}
