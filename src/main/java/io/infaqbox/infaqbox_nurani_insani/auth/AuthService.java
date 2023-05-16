package io.infaqbox.infaqbox_nurani_insani.auth;


import io.infaqbox.infaqbox_nurani_insani.user.User;
import io.infaqbox.infaqbox_nurani_insani.user.UserRequest;

import java.util.Optional;

public interface AuthService {
    public Optional<User> AddUser(UserRequest user);
}