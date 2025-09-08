package com.fmgarcia.taurus.templates.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmgarcia.taurus.templates.domain.EmailTemplate;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long>{

}
