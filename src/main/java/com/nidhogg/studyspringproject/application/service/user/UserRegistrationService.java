package com.nidhogg.studyspringproject.application.service.user;

import com.nidhogg.studyspringproject.annotation.ProfilePerformance;
import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import com.nidhogg.studyspringproject.application.exception.EmailExistsException;
import com.nidhogg.studyspringproject.application.mapper.user.UserMapper;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import com.nidhogg.studyspringproject.security.userdetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@ProfilePerformance
@Service
@Transactional
public class UserRegistrationService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto registerNewUser(RegistrationUserDto newUserDto) {
        if (userRepository.existsUserByEmail(newUserDto.getEmail())) {
            throw new EmailExistsException(newUserDto.getEmail());
        }

        User newUser = new User();
        newUser.setEmail(newUserDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(newUserDto.getPassword()));
        newUser.setRole(newUserDto.getRole());

        return userMapper.toDto(userRepository.save(newUser));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(user);
    }
}
