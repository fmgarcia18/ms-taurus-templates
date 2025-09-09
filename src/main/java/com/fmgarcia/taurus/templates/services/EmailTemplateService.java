package com.fmgarcia.taurus.templates.services;

import com.fmgarcia.taurus.templates.dtos.EmailTemplateRequestDTO;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateResponseDTO;

public interface EmailTemplateService {
	EmailTemplateResponseDTO createEmailTemplate(EmailTemplateRequestDTO emailTemplateRequestDTO);

	Iterable<EmailTemplateResponseDTO> findAllEmailTemplates();

	EmailTemplateResponseDTO findByCode(String code);

	EmailTemplateResponseDTO findByName(String name);
}
