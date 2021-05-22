package com.hardik.plutocracy.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "master_tags")
public class Tag implements Serializable {

	private static final long serialVersionUID = 7614500210597678021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
	private Set<NoteTagMapping> noteTagMappings;

	@Hidden
	@Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
	private Set<TicketTagMapping> ticketTagMappings;

	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.name = this.name.toUpperCase();
	}

}
