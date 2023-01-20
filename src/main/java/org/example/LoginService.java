package org.example;

public class LoginService {

    private DatabaseInterface databaseInterface;

    public LoginService(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    public AppUser findUserByUsername(String username) {
        return null;
    }

    public boolean login(String username, String password) throws Exception {
        return false;
    }
}
