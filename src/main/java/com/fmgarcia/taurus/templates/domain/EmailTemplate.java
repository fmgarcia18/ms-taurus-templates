package com.fmgarcia.taurus.templates.domain;

import java.io.Serializable;
import java.util.UUID;

import com.fmgarcia.taurus.templates.enums.EmailType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_templates")
public class EmailTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096496912701277477L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	private String description;

	@NotNull
	private String subject;

	@NotNull
	@Column(columnDefinition = "text")
	private String content;

	@NotNull
	private Boolean enabled;

	@NotNull
	private String code;

	@NotNull
	@Enumerated(EnumType.STRING)
	private EmailType type;

	@PrePersist
	public void setUUID() {
		code = UUID.randomUUID().toString();
	}

}
