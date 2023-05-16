package io.infaqbox.infaqbox_nurani_insani.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String roles;
}
