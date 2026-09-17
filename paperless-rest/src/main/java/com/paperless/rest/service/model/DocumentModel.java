package com.paperless.rest.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Pure Business Layer (BL) Domain Model.
 * Decoupled from both the presentation tier (DTO) and the persistence tier (DAL Entity).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentModel {
    private Long id;
    private String title;
    private String originalFilename;
    private String contentType;
    private Long fileSize;
    private String storagePath;
    private String ocrText;
    private String summary;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private List<String> tags;
}
