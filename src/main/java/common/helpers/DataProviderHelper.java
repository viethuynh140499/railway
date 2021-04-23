package common.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.constant.Constant;
import model.User;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderHelper {
  @DataProvider(name = "valid-user")
  public static Object[] getValidLoginData() throws IOException, ParseException {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = DataHelper.getJsonData(DataHelper.getProjectPath() + Constant.DATA_PATH + "login_successfully.json").toString();
    List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
    });
    return users.toArray();
  }

  @DataProvider(name = "invalid-user")
  public Object[] getInvalidLoginData() throws IOException, ParseException {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = DataHelper.getJsonData(Constant.DATA_PATH + "login_unsuccessfully.json").toString();
    List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
    });
    return users.toArray();
  }
}
