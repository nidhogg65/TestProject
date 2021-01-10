package com.nidhogg.studyspringproject.domain.model.user;


import com.nidhogg.studyspringproject.domain.model.common.BaseDomainEntity;
import com.nidhogg.studyspringproject.domain.model.common.EntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@EntityListeners(EntityListener.class)
@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseDomainEntity {

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private Role role;

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
