package io.github.binaitz.ableruserservice.web;

import io.github.binaitz.ableruserservice.domain.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SignUpRequest {

    private String id;
    private String password;

    public User toUser() {
        return User.builder()
                .userId(id)
                .password(password)
                .build();
    }
}
