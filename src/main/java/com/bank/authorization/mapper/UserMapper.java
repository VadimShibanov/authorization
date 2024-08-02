package com.bank.authorization.mapper;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    static UserMapper getInstance() {
        return new UserMapperImpl();
    }

    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> users);
}
