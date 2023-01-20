import org.example.AppUser;
import org.example.DatabaseInterface;
import org.example.LoginService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class LoginServiceTest {

    @Mock
    private DatabaseInterface databaseInterface;

    @InjectMocks
    private LoginService loginService;

    private final static String username = "username";
    private final static String password = "password";

    @Test
    public void  loginWithCorrectPassword_shouldReturnTrue() throws Exception {
        AppUser appUser = new AppUser(username, password);
        boolean result = loginService.login("username", "password");

        assertNull(appUser);

    }

    @Test
    public void  loginWithCorrectPassword_shouldThrowException() throws Exception {
        AppUser appUser = new AppUser(username, password);

        when(databaseInterface.findUserByUsername(username, password)).thenThrow();

        boolean result = loginService.login("wrongusername", "wrongpassword");

        assertNull(appUser);

    }
}
