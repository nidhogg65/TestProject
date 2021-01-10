package com.nidhogg.studyspringproject.dto.user;

import com.nidhogg.studyspringproject.domain.model.user.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private Long id;
    private UUID uuid;
    private String email;
    private String password;
    private Role role;

}
