package com.nidhogg.studyspringproject.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nidhogg.studyspringproject.domain.model.user.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    @JsonProperty("id")
    private String uuid;
    private String email;
    private String password;
    private Role role;

}
