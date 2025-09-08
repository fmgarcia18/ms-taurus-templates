package com.fmgarcia.taurus.templates.dtos;

import jakarta.validation.constraints.NotNull;

public record EmailTemplateRequestDTO(
		@NotNull
		String name,
		
		String description,
		
		@NotNull
		String subject,
		
		@NotNull
		String content,
		
		@NotNull
		Boolean enabled,
		
		@NotNull
		String type
) {}
