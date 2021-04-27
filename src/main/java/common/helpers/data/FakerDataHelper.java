package common.helpers.data;

import com.github.javafaker.Faker;

public class FakerDataHelper {
  private static Faker faker = new Faker();

  public static String randomEmailValid() {
    return faker.internet().emailAddress();
  }

  public static String randomPasswordValid() {
    return faker.letterify("?????????");
  }

  public static String randomPIDValid() {
    return faker.numerify("##########");
  }

  public static String randomEmailInvalid(){return faker.letterify("?????");}

  public static String randomPasswordInvalid(){return faker.letterify("???");}

  public static String randomPIDInvalid(){return faker.numerify("#####");}
}
