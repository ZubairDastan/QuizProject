import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateQuiz {
    public void updateQuiz() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        String fileName="./src/main/resources/QuizList.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        System.out.println("Enter the quiz no you want to update:");
        String i = input.nextLine();
        JSONObject update = (JSONObject) jsonArray.get(Character.getNumericValue(i.charAt(0)-1));
        System.out.println("Enter the question to be stored:");
        update.put("Q.", input.nextLine());
        System.out.println("Enter option 'a'");
        update.put("(a)",input.nextLine());
        System.out.println("Enter option 'b'");
        update.put("(b)",input.nextLine());
        System.out.println("Enter option 'c'");
        update.put("(c)",input.nextLine());
        System.out.println("Enter option 'd'");
        update.put("(d)",input.nextLine());
        System.out.println("Enter the correct answer of the question to be stored:");
        update.put("Ans.", input.nextLine());
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Updated!");
        System.out.print(jsonArray);
    }
}
