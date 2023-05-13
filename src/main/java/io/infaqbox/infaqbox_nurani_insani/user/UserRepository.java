package io.infaqbox.infaqbox_nurani_insani.user;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameIgnoreCase(String username);

    boolean existsByCompleteName(String completeName);

}
