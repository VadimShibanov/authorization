package com.bank.authorization.service;

import com.bank.authorization.model.Audit;
import com.bank.authorization.model.Role;
import com.bank.authorization.model.User;
import com.bank.authorization.repository.AuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.any;

import java.time.ZonedDateTime;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuditServiceTest {
    @Mock
    AuditRepository auditRepository;

    @Mock
    ObjectMapper objectMapper;

    @InjectMocks
    AuditServiceImpl auditServiceImpl;
    @Test
    void auditGetAll() {

        User user = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        Audit expectedAudit = new Audit();

        expectedAudit.setEntityType("User");
        expectedAudit.setOperationType("GetAll");
        expectedAudit.setCreatedBy("admin");
        expectedAudit.setCreatedAt(ZonedDateTime.now());
        try {
            expectedAudit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        when(auditRepository.save(any())).thenReturn(expectedAudit);

        Audit actualAudit = auditServiceImpl.auditGetAll(user);

        assertEquals(expectedAudit, actualAudit);

    }

    @Test
    void auditGet() {

        User user = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        Audit expectedAudit = new Audit();

        expectedAudit.setEntityType("User");
        expectedAudit.setOperationType("Get");
        expectedAudit.setCreatedBy("admin");
        expectedAudit.setCreatedAt(ZonedDateTime.now());
        try {
            expectedAudit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        when(auditRepository.save(any())).thenReturn(expectedAudit);

        Audit actualAudit = auditServiceImpl.auditGet(user);

        assertEquals(expectedAudit, actualAudit);

    }

    @Test
    void auditDelete() {

        User user = new User(1L, "admin", "100", 1, Set.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));

        Audit expectedAudit = new Audit();

        expectedAudit.setEntityType("User");
        expectedAudit.setOperationType("Delete");
        expectedAudit.setCreatedBy("admin");
        expectedAudit.setCreatedAt(ZonedDateTime.now());
        try {
            expectedAudit.setEntityJson(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        when(auditRepository.save(any())).thenReturn(expectedAudit);

        Audit actualAudit = auditServiceImpl.auditDelete(user);

        assertEquals(expectedAudit, actualAudit);

    }

}
