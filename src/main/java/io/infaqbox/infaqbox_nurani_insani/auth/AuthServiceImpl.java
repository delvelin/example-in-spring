package io.infaqbox.infaqbox_nurani_insani.auth;


import io.infaqbox.infaqbox_nurani_insani.user.User;
import io.infaqbox.infaqbox_nurani_insani.user.UserRepository;
import io.infaqbox.infaqbox_nurani_insani.user.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

//    public Optional<User> AddUser(UserRequest user) {
//        User newUser = new Users();
//        newUser.setFirst_name(user.getFirst_name());
//        newUser.setLast_name(user.getLast_name());
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        newUser.setRoles("ROLE_USER");
//        return Optional.of(usersRepository.save(newUser));
//    }

    @Override
    public Optional<User> AddUser(UserRequest user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirst_name());
        newUser.setLastName(user.getLast_name());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles("ROLE_USER");
        return Optional.of(userRepository.save(newUser));
    }
}