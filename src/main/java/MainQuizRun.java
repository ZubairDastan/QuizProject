import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainQuizRun {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to play the quiz,\nEnter '2' to add quiz in the list,\nEnter '3' to update quiz list,\nEnter '4' to see all quiz list,\nEnter '0' to exit");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                String fileName = "./src/main/resources/QuizList.json";
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(new FileReader(fileName));
                JSONArray jsonArray = (JSONArray) obj;
                //Code from here


            case 2:
                AddQuiz add = new AddQuiz();
                add.addQuiz();
                break;

            case 3:
                UpdateQuiz update = new UpdateQuiz();
                update.updateQuiz();
                break;

            case 4:
                ReadQuiz read = new ReadQuiz();
                read.readQuiz();
                break;

            case 0:
                break;

            default:
                System.out.println("Please select a choice.");

        }
    }
}
