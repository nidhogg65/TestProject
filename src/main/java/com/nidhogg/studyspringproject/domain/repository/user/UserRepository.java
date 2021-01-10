package com.nidhogg.studyspringproject.domain.repository.user;

import com.nidhogg.studyspringproject.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);

    Optional<User> findByUuid(String uuid);

}
