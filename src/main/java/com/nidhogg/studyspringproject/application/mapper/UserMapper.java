package com.nidhogg.studyspringproject.application.mapper;

import com.nidhogg.studyspringproject.dto.user.UserDto;
import com.nidhogg.studyspringproject.domain.model.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

}
