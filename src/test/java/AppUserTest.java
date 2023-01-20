import org.example.AppUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AppUserTest {

    private final static String username = "gunnar";
    private final static String password = "password";

    @Test
    public void  constructor_shouldReturnAppUser() {
        AppUser appUser = new AppUser();

        assertNotNull(appUser);
    }

    @Test
    public void getUsername_shouldReturnUsername() {
        AppUser appUser = new AppUser(username, password);

        String username = appUser.getUsername();

        assertNotNull(username);
    }

    @Test
    public void equals_shouldReturnTrueForSameUserName() {
        AppUser appUser = new AppUser(username, password);

        String username = appUser.getUsername();

        assertEquals("gunnar", username);
    }


}

