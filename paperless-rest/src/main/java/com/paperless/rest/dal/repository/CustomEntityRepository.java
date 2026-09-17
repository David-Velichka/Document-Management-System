package com.paperless.rest.dal.repository;

import com.paperless.rest.dal.entity.CustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomEntityRepository extends JpaRepository<CustomEntity, Long> {
    List<CustomEntity> findByDocumentId(Long documentId);
}
