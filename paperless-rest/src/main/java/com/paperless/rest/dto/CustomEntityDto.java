package com.paperless.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * DTO for the individually defined 4th use-case (e.g. document tags, categories, or audit logs).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomEntityDto {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private String description;
    private Long documentId;
    private OffsetDateTime createdAt;
}
