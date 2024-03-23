package dpat.simple.solution;

import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Osas
 */
public class UserManager {
    private Map<String, String> userCredentials = new HashMap<>();

    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        return password.equals(userCredentials.getOrDefault(username, ""));
    }
}
