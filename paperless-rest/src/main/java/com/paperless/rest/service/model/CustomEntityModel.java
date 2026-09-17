package com.paperless.rest.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * Pure Business Layer (BL) Domain Model for custom use case.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomEntityModel {
    private Long id;
    private String name;
    private String description;
    private Long documentId;
    private OffsetDateTime createdAt;
}
