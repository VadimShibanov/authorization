package com.bank.authorization.mapper;

import com.bank.authorization.dto.AuditDto;
import com.bank.authorization.model.Audit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    static AuditMapper getInstance() {
        return new AuditMapperImpl();
    }

    List<AuditDto> toAuditListDto(List<Audit> audits);
}
