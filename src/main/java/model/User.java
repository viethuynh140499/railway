package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String welcomeMessage;
    private String pid;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
