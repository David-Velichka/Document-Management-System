package com.paperless.rest.service.impl;

import com.paperless.rest.dal.entity.CustomEntity;
import com.paperless.rest.dal.repository.CustomEntityRepository;
import com.paperless.rest.exception.BusinessLayerException;
import com.paperless.rest.mapper.CustomEntityMapper;
import com.paperless.rest.service.CustomEntityService;
import com.paperless.rest.service.model.CustomEntityModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CustomEntityServiceImpl implements CustomEntityService {

    private final CustomEntityRepository customEntityRepository;
    private final CustomEntityMapper customEntityMapper;

    @Override
    public CustomEntityModel create(CustomEntityModel model) {
        log.info("Creating custom entity: {}", model.getName());
        CustomEntity entity = customEntityMapper.toEntity(model);
        CustomEntity saved = customEntityRepository.save(entity);
        return customEntityMapper.toModel(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomEntityModel findById(Long id) {
        log.debug("Finding custom entity by id: {}", id);
        return customEntityRepository.findById(id)
                .map(customEntityMapper::toModel)
                .orElseThrow(() -> new BusinessLayerException("CustomEntity with id " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomEntityModel> findByDocumentId(Long documentId) {
        log.debug("Finding custom entities by documentId: {}", documentId);
        List<CustomEntity> entities = customEntityRepository.findByDocumentId(documentId);
        return customEntityMapper.toModelList(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomEntityModel> findAll() {
        return customEntityMapper.toModelList(customEntityRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting custom entity by id: {}", id);
        if (!customEntityRepository.existsById(id)) {
            throw new BusinessLayerException("CustomEntity with id " + id + " does not exist");
        }
        customEntityRepository.deleteById(id);
    }
}
