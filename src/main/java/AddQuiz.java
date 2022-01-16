import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddQuiz {
    public void addQuiz() throws IOException, ParseException {
        char ch = 'y';
        String fileName = "./src/main/resources/QuizList.json";
        do {
            JSONParser jsonParser = new JSONParser();
            JSONObject quizList = new JSONObject();
            Object object = jsonParser.parse(new FileReader(fileName));

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the question to be stored:");
            quizList.put("Q.", input.nextLine());
            System.out.println("Enter option 'a'");
            quizList.put("(a)", input.nextLine());
            System.out.println("Enter option 'b'");
            quizList.put("(b)", input.nextLine());
            System.out.println("Enter option 'c'");
            quizList.put("(c)", input.nextLine());
            System.out.println("Enter option 'd'");
            quizList.put("(d)", input.nextLine());
            System.out.println("Enter the correct answer of the question to be stored:");
            quizList.put("Ans.", input.nextLine());

            JSONArray jsonArray = (JSONArray) object;
            jsonArray.add(quizList);
            System.out.print(jsonArray);

            FileWriter file = new FileWriter(fileName);

            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.println("\nDo you want to add more?[y/n]");
            ch = input.next().charAt(0);
        }
        while (ch != 'n');
    }
}
