package com.compunet.bookstore.persistence.dto.mapper;

import org.springframework.cglib.core.internal.Function;

import com.compunet.bookstore.persistence.dto.UserDto;
import com.compunet.bookstore.persistence.models.User;

public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getUsername());
    }
}
