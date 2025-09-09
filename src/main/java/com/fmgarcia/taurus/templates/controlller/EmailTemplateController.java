package com.fmgarcia.taurus.templates.controlller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fmgarcia.taurus.templates.dtos.EmailTemplateRequestDTO;
import com.fmgarcia.taurus.templates.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.taurus.templates.services.EmailTemplateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/templates")
public class EmailTemplateController {
	
	private final EmailTemplateService emailTemplateService;
	
	@PostMapping
	public ResponseEntity<?> createEmailTemplate(@Valid @RequestBody EmailTemplateRequestDTO request) {
		log.info(request.toString());
		EmailTemplateResponseDTO emailTemplate = emailTemplateService.createEmailTemplate(request);

		// Set the headers for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}")
				.buildAndExpand(emailTemplate.code()).toUri());

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<EmailTemplateResponseDTO>> getAllEmailTemplates() {
		return ResponseEntity.ok(emailTemplateService.findAllEmailTemplates());
	}

	@GetMapping("/{code}")
	public ResponseEntity<EmailTemplateResponseDTO> getEmailTemplateByCode(@PathVariable String code) {
		return ResponseEntity.ok(emailTemplateService.findByCode(code));
	}

}
