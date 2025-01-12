package com.bank.authorization.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class AuditDto {

    private Long id;

    private String entityType;

    private String operationType;

    private String createdBy;

    private String modifiedBy;

    private ZonedDateTime createdAt;

    private ZonedDateTime modifiedAt;

    private String newEntityJson;

    private String entityJson;
}
