package com.nidhogg.studyspringproject.domain.repository.user;


import com.nidhogg.studyspringproject.domain.model.user.Role;
import com.nidhogg.studyspringproject.domain.model.user.User;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.dbunit.DBUnitSupport;
import org.flywaydb.test.dbunit.FlywayDBUnitTestExecutionListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

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
        //given
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setEmail("test1@gmail.com");
        expectedUser.setPassword("1q2w3e");
        expectedUser.setRole(Role.ADMIN);

        // when
        User actualUser = userRepository.findByEmail("test1@gmail.com");

        // then
        assertThat(actualUser).isEqualToComparingFieldByField(expectedUser);
    }
}
