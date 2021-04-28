package com.forgottenrelations.forgottenRelationsBlog.data;

import com.forgottenrelations.forgottenRelationsBlog.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class UserData {
    private static Map<String, User> users = new HashMap<>();

    public static Collection<User> getAll() {
        return users.values();
    }

    public static User getUserByEmail(String email) {
        return users.get(email);
    }

    public static void addUser(User newUser) {
        users.put(newUser.getEmail(), newUser);
    }

    public static Boolean containsUser(User user) {
        return users.containsKey(user.getEmail());
    }

    public static Boolean containsUserByEmail(String email) {
        return users.containsKey(email);
    }


}
