package dd.projects.ddshop.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {

    private String username;

    private String password;
}
