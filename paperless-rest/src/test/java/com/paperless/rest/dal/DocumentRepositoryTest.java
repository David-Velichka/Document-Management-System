package com.paperless.rest.dal;

import com.paperless.rest.dal.entity.DocumentEntity;
import com.paperless.rest.dal.repository.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DocumentRepositoryTest {

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    void saveAndFindDocument() {
        DocumentEntity entity = DocumentEntity.builder()
                .title("Accounting Report 2026")
                .originalFilename("accounting.pdf")
                .build();

        DocumentEntity saved = documentRepository.save(entity);
        assertNotNull(saved.getId());

        List<DocumentEntity> found = documentRepository.findByTitleContainingIgnoreCase("Accounting");
        assertFalse(found.isEmpty());
        assertEquals("Accounting Report 2026", found.get(0).getTitle());
    }
}
