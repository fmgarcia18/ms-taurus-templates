package com.fmgarcia.taurus.templates.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmgarcia.taurus.templates.domain.EmailTemplate;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long>{
	Optional<EmailTemplate> findByCode(String code);

	Optional<EmailTemplate> findByName(String name);

}
