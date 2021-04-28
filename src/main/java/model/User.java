package model;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {
  private String username ;
  private String password;
  private String confirmPassword;
  private String welcomeMessage;
  private String pid;
}
