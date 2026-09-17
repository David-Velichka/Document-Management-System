package com.paperless.rest.controller;

import com.paperless.rest.dto.CustomEntityDto;
import com.paperless.rest.mapper.CustomEntityMapper;
import com.paperless.rest.service.CustomEntityService;
import com.paperless.rest.service.model.CustomEntityModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custom-entities")
@RequiredArgsConstructor
@Slf4j
public class CustomEntityController {

    private final CustomEntityService customEntityService;
    private final CustomEntityMapper customEntityMapper;

    @GetMapping
    public ResponseEntity<List<CustomEntityDto>> getAll() {
        log.info("REST request to get all custom entities");
        return ResponseEntity.ok(customEntityMapper.toDtoList(customEntityService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomEntityDto> getById(@PathVariable Long id) {
        log.info("REST request to get custom entity: {}", id);
        return ResponseEntity.ok(customEntityMapper.toDto(customEntityService.findById(id)));
    }

    @GetMapping("/by-document/{documentId}")
    public ResponseEntity<List<CustomEntityDto>> getByDocumentId(@PathVariable Long documentId) {
        log.info("REST request to get custom entities for document: {}", documentId);
        return ResponseEntity.ok(customEntityMapper.toDtoList(customEntityService.findByDocumentId(documentId)));
    }

    @PostMapping
    public ResponseEntity<CustomEntityDto> create(@Valid @RequestBody CustomEntityDto dto) {
        log.info("REST request to create custom entity: {}", dto.getName());
        CustomEntityModel model = customEntityMapper.toModel(dto);
        CustomEntityModel created = customEntityService.create(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(customEntityMapper.toDto(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("REST request to delete custom entity: {}", id);
        customEntityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
