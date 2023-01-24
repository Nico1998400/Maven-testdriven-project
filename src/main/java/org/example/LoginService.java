package org.example;

public class LoginService {
    private final DatabaseInterface databaseInterface;

    public LoginService(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    public boolean login(String username, String password) throws Exception {
        AppUser appUser = databaseInterface.findUserByUsernameAndPassword(username, password).orElseThrow();
        if (!appUser.getPassword().equals(password)) {
            throw new Exception("Incorrect password.");
        }
        return true;
    }
}

