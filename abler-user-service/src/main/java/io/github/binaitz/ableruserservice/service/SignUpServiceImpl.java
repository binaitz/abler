package io.github.binaitz.ableruserservice.service;

import io.github.binaitz.ableruserservice.domain.User;
import io.github.binaitz.ableruserservice.domain.UserAlreadyExistsException;
import io.github.binaitz.ableruserservice.domain.UserRepository;
import io.github.binaitz.ableruserservice.web.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;

    @Override
    public User signUp(SignUpRequest signUpRequest) throws UserAlreadyExistsException {
        if (userExists(signUpRequest.getId())) {
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(signUpRequest.toUser());
    }

    private boolean userExists(String userId) {
        return userRepository.findByUserId(userId)
                .isPresent();
    }
}
