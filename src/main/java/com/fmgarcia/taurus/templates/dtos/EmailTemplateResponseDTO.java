package com.fmgarcia.taurus.templates.dtos;

public record EmailTemplateResponseDTO(
		
		String name,
		String description,
		String subject,
		String content,
		Boolean enabled,
		String type,
		String code
		) {}
