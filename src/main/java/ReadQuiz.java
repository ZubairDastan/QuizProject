import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadQuiz {
    public void readQuiz () throws IOException, ParseException {
        String fileName="./src/main/resources/QuizList.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray);
        JSONObject json = (JSONObject) jsonArray.get(0);

        String question = (String) json.get("Q.");
        String answer = (String) json.get("A.");

        System.out.println(question);
        System.out.println(answer);

    }
}
