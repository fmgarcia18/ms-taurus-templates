package com.fmgarcia.taurus.templates.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.fmgarcia.taurus.templates.domain.EmailTemplate;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateRequestDTO;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmailTemplateMapper {
	
	EmailTemplate toEmailTemplate(EmailTemplateRequestDTO request);

	EmailTemplateResponseDTO toResponseDTO(EmailTemplate emailTemplate);

	Iterable<EmailTemplateResponseDTO> toEmailTemplateDTOs(Iterable<EmailTemplate> emailTemplates);

}
