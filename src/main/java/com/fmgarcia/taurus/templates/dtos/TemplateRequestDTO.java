package com.fmgarcia.taurus.templates.dtos;

import jakarta.validation.constraints.NotNull;

public record TemplateRequestDTO(
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
