package common.helpers.data;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataHelper {
  public static JSONArray getJsonData(String pathFileJson) throws  IOException, ParseException {
    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader(pathFileJson);
    Object obj = jsonParser.parse(reader);
    return (JSONArray) obj;
  }
}
