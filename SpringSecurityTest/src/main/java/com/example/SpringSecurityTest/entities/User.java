package com.example.SpringSecurityTest.entities;


import com.example.SpringSecurityTest.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.message.Message;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_table")
@Validated
public class User implements UserDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @NotNull(message = "name should not be null")
    private String name;

    private String email;

    private String password;

    private String about;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
