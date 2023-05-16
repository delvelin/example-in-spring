package io.infaqbox.infaqbox_nurani_insani.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameIgnoreCase(String username);

    boolean existsByFirstNameIgnoreCase(String firstName);

    Optional<User> findByUsername(String username);

}
