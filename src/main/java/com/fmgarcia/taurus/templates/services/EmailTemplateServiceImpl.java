package com.fmgarcia.taurus.templates.services;

import org.springframework.stereotype.Service;

import com.fmgarcia.taurus.templates.domain.EmailTemplate;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateRequestDTO;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.taurus.templates.mappers.EmailTemplateMapper;
import com.fmgarcia.taurus.templates.repositories.EmailTemplateRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailTemplateServiceImpl implements EmailTemplateService{
	
	private final EmailTemplateMapper mapper;

	private final EmailTemplateRepository repository;

	@Override
	public EmailTemplateResponseDTO createEmailTemplate(EmailTemplateRequestDTO emailTemplateRequestDTO) {
		EmailTemplate emailTemplate = mapper.toEmailTemplate(emailTemplateRequestDTO);
		
		log.info("Conversion del EmailTemplate");
		log.info(emailTemplate.toString());

		EmailTemplate newEmailTemplate = repository.save(emailTemplate);

		EmailTemplateResponseDTO responseDTO = mapper.toResponseDTO(newEmailTemplate);

		return responseDTO;
	}

	@Override
	public Iterable<EmailTemplateResponseDTO> findAllEmailTemplates() {
		log.info("buscando todos los templates");
		Iterable<EmailTemplate> emailTemplates = repository.findAll();

		Iterable<EmailTemplateResponseDTO> emailTemplateResponseDTOS = mapper.toEmailTemplateDTOs(emailTemplates);

		return emailTemplateResponseDTOS;
	}

	@Override
	public EmailTemplateResponseDTO findByCode(String code) {
		log.info(String.format("buscando un template por su code: %s", code));
		EmailTemplate emailTemplate = repository.findByCode(code)
				.orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

		log.info("hacemos el mapper con el ResponseDTO");
		EmailTemplateResponseDTO responseDTO = mapper.toResponseDTO(emailTemplate);

		return responseDTO;
	}

	@Override
	public EmailTemplateResponseDTO findByName(String name) {
		log.info("buscando un template por su name");
		EmailTemplate emailTemplate = repository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

		log.info("hacemos el mapper con el ResponseDTO");
		EmailTemplateResponseDTO responseDTO = mapper.toResponseDTO(emailTemplate);

		return responseDTO;
	}

}
