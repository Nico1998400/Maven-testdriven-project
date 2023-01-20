package org.example;

import java.util.Optional;

public interface DatabaseInterface {
    Optional<AppUser> findUserByUsername(String username, String password);

}
