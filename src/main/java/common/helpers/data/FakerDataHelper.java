package common.helpers.data;

import com.github.javafaker.Faker;

public class FakerDataHelper {
  private static Faker faker = new Faker();

  public static String getRandomEmailValid() {
    return faker.internet().emailAddress();
  }

  public static String getRandomPasswordValid() {
    return faker.letterify("?????????");
  }

  public static String getRandomPIDValid() {
    return faker.numerify("##########");
  }

  public static String getRandomEmailInvalid(){return faker.letterify("?????");}

  public static String getRandomPasswordInvalid(){return faker.letterify("???");}

  public static String getRandomPIDInvalid(){return faker.numerify("#####");}
}
