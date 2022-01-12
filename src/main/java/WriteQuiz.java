import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteQuiz {
    public static void main(String[] args) throws IOException, ParseException {
        char ch = 'y';
        String fileName = "./src/main/resources/QuizList.json";
        do {
            JSONParser jsonParser = new JSONParser();
            JSONObject quizList = new JSONObject();
            Object obj = jsonParser.parse(new FileReader(fileName));

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the question to be stored:");
            quizList.put("Q.", input.next());
            System.out.println("Enter the answer of the question to be stored:");
            quizList.put("A.", input.next());

            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(quizList);
            System.out.print(jsonArray);

            FileWriter file = new FileWriter(fileName);

            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.print(jsonArray);
            System.out.println("\nDo you want to add more?[y/n]");
            ch = input.next().charAt(0);
        }
        while (ch != 'n');
    }
}
