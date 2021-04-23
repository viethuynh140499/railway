package test_cases.draft;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class FakeData {

  @Test
  public void test1(){
    Faker faker = new Faker(new Locale("vi"));

    System.out.println(faker.internet().emailAddress());
  }
}
