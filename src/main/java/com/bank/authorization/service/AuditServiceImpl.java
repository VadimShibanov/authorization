package com.bank.authorization.service;

import com.bank.authorization.model.Audit;
import com.bank.authorization.model.User;
import com.bank.authorization.repository.AuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public Audit auditGetAll(User user) {
        Audit audit = new Audit();

        audit.setEntityType("User");
        audit.setOperationType("GetAll");
        audit.setCreatedBy(user.getUsername().toString());
        audit.setCreatedAt(ZonedDateTime.now());
        try {
            audit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return auditRepository.save(audit);
    }

    @Transactional
    public Audit auditGet(User user) {
        Audit audit = new Audit();

        audit.setEntityType("User");
        audit.setOperationType("Get");
        audit.setCreatedBy(user.getUsername().toString());
        audit.setCreatedAt(ZonedDateTime.now());
        try {
            audit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return auditRepository.save(audit);
    }

    @Transactional
    public Audit auditDelete(User user) {
        Audit audit = new Audit();

        audit.setEntityType("User");
        audit.setOperationType("Delete");
        audit.setCreatedBy(user.getUsername().toString());
        audit.setCreatedAt(ZonedDateTime.now());
        try {
            audit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return auditRepository.save(audit);
    }
}
