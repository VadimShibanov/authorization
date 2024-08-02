package com.bank.authorization.mapper;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserMapperTest {

    private UserMapper userMapper = UserMapper.getInstance();

    @Test
    void getInstance() {

        UserMapper actualResult = UserMapper.getInstance();
        UserMapper expectedResult = new UserMapperImpl();

        assertThat(actualResult.getClass()).isEqualTo(expectedResult.getClass());
    }

    @Test
    void toUserDto() {

        User user = new User();

        UserDto actualResult = userMapper.toUserDto(user);

        UserDto expectedResult = new UserDto();

        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    void toUserDtoList() {

        List<User> testList = new ArrayList<>();

        testList.add(new User());

        List<UserDto> actualResult = userMapper.toUserDtoList(testList);

        List<UserDto> testDtoList = new ArrayList<>();

        testDtoList.add(new UserDto());

        List<UserDto> expectedResult = testDtoList;

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}