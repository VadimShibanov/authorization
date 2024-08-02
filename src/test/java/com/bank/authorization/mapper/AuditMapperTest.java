package com.bank.authorization.mapper;

import com.bank.authorization.dto.AuditDto;
import com.bank.authorization.model.Audit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AuditMapperTest {

    private AuditMapper auditMapper = AuditMapper.getInstance();

    @Test
    void getInstance() {

        AuditMapper actualResult = AuditMapper.getInstance();
        AuditMapper expectedResult = new AuditMapperImpl();

        assertThat(actualResult.getClass()).isEqualTo(expectedResult.getClass());
    }

    @Test
    void toAuditListToDTO() {

        List<Audit> testList = new ArrayList<>();

        testList.add(new Audit());

        List<AuditDto> actualResult = auditMapper.toAuditListDto(testList);

        List<AuditDto> testDtoList = new ArrayList<>();

        testDtoList.add(new AuditDto());

        List<AuditDto> expectedResult = testDtoList;

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}