package model;

import com.github.javafaker.Faker;

public class RegisterFaker {
  Faker userFaker = new Faker();

  String username =  userFaker.internet().emailAddress();
  String password = userFaker.internet().password();
  String confirmPassword = userFaker.internet().password();
  Double pid = userFaker.number().randomDouble(10,1,10);




}
