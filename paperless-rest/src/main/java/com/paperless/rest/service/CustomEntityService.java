package com.paperless.rest.service;

import com.paperless.rest.service.model.CustomEntityModel;

import java.util.List;

/**
 * Service interface for business logic operations on the custom entity.
 */
public interface CustomEntityService {
    CustomEntityModel create(CustomEntityModel model);
    CustomEntityModel findById(Long id);
    List<CustomEntityModel> findByDocumentId(Long documentId);
    List<CustomEntityModel> findAll();
    void deleteById(Long id);
}
