package com.nidhogg.studyspringproject.domain.repository.user;


import com.nidhogg.studyspringproject.domain.model.user.User;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.dbunit.DBUnitSupport;
import org.flywaydb.test.dbunit.FlywayDBUnitTestExecutionListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static com.google.common.truth.Truth.assertThat;
import static com.nidhogg.studyspringproject.domain.model.user.Role.ADMIN;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "spring.h2.console.enabled=true")
@FlywayTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FlywayDBUnitTestExecutionListener.class})
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @FlywayTest(invokeCleanDB = true)
    @DBUnitSupport(loadFilesForRun = {"INSERT", "/testdata/user.xml"})
    public void shouldReturnUser_whenFindByEmail_givenExistingEmail() {
        // when
        User actualUser = userRepository.findByEmail("test1@gmail.com");

        // then
        assertThat(actualUser.getId()).isEqualTo(1L);
        assertThat(actualUser.getEmail()).isEqualTo("test1@gmail.com");
        assertThat(actualUser.getPassword()).isEqualTo("1q2w3e");
        assertThat(actualUser.getRole()).isEqualTo(ADMIN);
    }
}
