package common.helpers;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
  public static JSONArray getJsonData(String pathFileJson) throws IOException, ParseException {

    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader(pathFileJson);
    Object obj = jsonParser.parse(reader);
    return (JSONArray) obj;
  }

  public static String getRandomDepartDate() {
    Calendar cal = Calendar.getInstance();
    int ranNum = ThreadLocalRandom.current().nextInt(4, 30);
    cal.add(Calendar.DATE, ranNum);
    return new SimpleDateFormat("M/d/yyyy").format(cal.getTime());
  }

  public static String getDateFromToday(int num) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, num);
    return new SimpleDateFormat("M/d/yyyy").format(cal.getTime());
  }

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

  public static String getRandomEmailInvalid() {
    return faker.letterify("?????");
  }

  public static String getRandomPasswordInvalid() {
    return faker.letterify("???");
  }

  public static String getRandomPIDInvalid() {
    return faker.numerify("#####");
  }
}
