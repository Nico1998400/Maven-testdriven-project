package org.example;

import java.io.OptionalDataException;
import java.util.Optional;

public interface DatabaseInterface {
    Optional<AppUser> findUserByUsernameAndPassword(String username, String password);

}
