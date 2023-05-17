package io.infaqbox.infaqbox_nurani_insani.auth;


import io.infaqbox.infaqbox_nurani_insani.user.User;
import io.infaqbox.infaqbox_nurani_insani.user.UserRepository;
import io.infaqbox.infaqbox_nurani_insani.user.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;


    @Override
    public Optional<User> AddUser(UserRequest user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirst_name());
        newUser.setLastName(user.getLast_name());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRoles(user.getRoles());
        newUser.setDateCreated(OffsetDateTime.now());
        newUser.setLastUpdated(OffsetDateTime.now());
        return Optional.of(userRepository.save(newUser));
    }
}