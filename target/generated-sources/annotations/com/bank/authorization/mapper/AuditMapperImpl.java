package com.bank.authorization.mapper;

import com.bank.authorization.dto.AuditDto;
import com.bank.authorization.model.Audit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-19T12:54:23+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class AuditMapperImpl implements AuditMapper {

    @Override
    public List<AuditDto> toAuditListDto(List<Audit> audits) {
        if ( audits == null ) {
            return null;
        }

        List<AuditDto> list = new ArrayList<AuditDto>( audits.size() );
        for ( Audit audit : audits ) {
            list.add( auditToAuditDto( audit ) );
        }

        return list;
    }

    protected AuditDto auditToAuditDto(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditDto auditDto = new AuditDto();

        auditDto.setId( audit.getId() );
        auditDto.setEntityType( audit.getEntityType() );
        auditDto.setOperationType( audit.getOperationType() );
        auditDto.setCreatedBy( audit.getCreatedBy() );
        auditDto.setModifiedBy( audit.getModifiedBy() );
        auditDto.setCreatedAt( audit.getCreatedAt() );
        auditDto.setModifiedAt( audit.getModifiedAt() );
        auditDto.setNewEntityJson( audit.getNewEntityJson() );
        auditDto.setEntityJson( audit.getEntityJson() );

        return auditDto;
    }
}
