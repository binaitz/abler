package io.github.binaitz.ableruserservice.service;

import io.github.binaitz.ableruserservice.domain.User;
import io.github.binaitz.ableruserservice.web.SignUpRequest;

public interface SignUpService {

    User signUp(SignUpRequest signUpRequest);
}
