package com.nidhogg.studyspringproject.application.service.user;

import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import com.nidhogg.studyspringproject.application.exception.EmailExistsException;
import com.nidhogg.studyspringproject.application.mapper.user.UserMapper;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationUserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationUserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto registerNewUser(RegistrationUserDto newUserDto) {
        if (userRepository.existsUserByEmail(newUserDto.getEmail())) {
            throw new EmailExistsException("Account with that email address: " + newUserDto.getEmail() + " already exists.");
        }

        User newUser = new User();
        newUser.setEmail(newUserDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(newUserDto.getPassword()));
        newUser.setRole(newUserDto.getRole());

        return userMapper.toDto(userRepository.save(newUser));
    }
}
