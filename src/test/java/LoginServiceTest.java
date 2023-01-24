import org.example.AppUser;
import org.example.DatabaseInterface;
import org.example.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    @Mock
    private DatabaseInterface databaseInterface;
    private final static String username = "username";
    private final static String password = "password";
    private LoginService loginService;

    @BeforeEach
    public void setUp() {
        loginService = new LoginService(databaseInterface);
    }

    @Test
    public void loginWithCorrectUsernameAndPassword_shouldReturnTrue() throws Exception {
        AppUser appUser = new AppUser(username, password);
        when(databaseInterface.findUserByUsernameAndPassword("username", "password")).thenReturn(Optional.of(appUser));

        assertTrue(loginService.login("username", "password"));
    }

    @Test
    public void getAppUserWithIncorrectUsernameOrPassword_shouldThrowException() throws Exception {
        AppUser appUser = new AppUser(username, password);
        when(databaseInterface.findUserByUsernameAndPassword("username", "password")).thenReturn(Optional.of(appUser));

        assertThrows(Exception.class, () -> loginService.login("username", "wrongpassword"));

    }
}
