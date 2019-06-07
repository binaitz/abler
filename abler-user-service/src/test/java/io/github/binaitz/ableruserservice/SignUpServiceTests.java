package io.github.binaitz.ableruserservice;

import io.github.binaitz.ableruserservice.domain.User;
import io.github.binaitz.ableruserservice.domain.UserAlreadyExistsException;
import io.github.binaitz.ableruserservice.domain.UserRepository;
import io.github.binaitz.ableruserservice.service.SignUpService;
import io.github.binaitz.ableruserservice.web.SignUpRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SignUpServiceTests {

    private static final String USER_ID = "idfortest";
    private static final String PASSWORD = "passwordfortest";

    @Autowired
    private SignUpService signUpService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void signUp() {
        // given
        SignUpRequest signUpRequest = signUpRequest();

        given(userRepository.findByUserId(USER_ID)).willReturn(Optional.empty());

        // when
        signUpService.signUp(signUpRequest);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void signUpWithConflictingId() {
        // given
        SignUpRequest signUpRequest = signUpRequest();

        User user = User.builder()
                .userId(USER_ID)
                .password(PASSWORD)
                .build();

        given(userRepository.findByUserId(USER_ID)).willReturn(Optional.of(user));

        // when
        signUpService.signUp(signUpRequest);
    }

    private SignUpRequest signUpRequest() {
        return SignUpRequest.builder()
                .id(USER_ID)
                .password(PASSWORD)
                .build();
    }
}
