package io.github.binaitz.ableruserservice;

import io.github.binaitz.ableruserservice.domain.User;
import io.github.binaitz.ableruserservice.service.SignUpService;
import io.github.binaitz.ableruserservice.web.SignUpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SignUpServiceTests {

    private static final String USER_ID = "idfortest";
    private static final String PASSWORD = "passwordfortest";

    @Autowired
    private SignUpService signUpService;

    @Test
    public void signUp() {
        SignUpRequest signUpRequest = SignUpRequest.builder()
                .id(USER_ID)
                .password(PASSWORD)
                .build();

        User user = signUpService.signUp(signUpRequest);

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(user.getUserId(), USER_ID);
        assertEquals(user.getPassword(), PASSWORD);
    }
}
