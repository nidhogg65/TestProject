package com.nidhogg.studyspringproject.security.authentication;

import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticatedUserHolder {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.getByEmail(getAuthentication().getName());
    }

    public Long getCurrentUserId() {
        return userRepository.getByEmail(getAuthentication().getName()).getId();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
