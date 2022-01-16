import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainQuizRun {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to play the quiz,\nEnter '2' to add quiz in the list,\nEnter '3' to update quiz list,\nEnter '4' to see all quiz list,\nEnter '0' to exit");
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                int count = 0;
                for (int i = 0; i < 5; i++) {
                    Random random = new Random();
                    String fileName = "./src/main/resources/QuizList.json";
                    JSONParser jsonParser = new JSONParser();
                    Object obj = jsonParser.parse(new FileReader(fileName));
                    JSONArray jsonArray = (JSONArray) obj;
                    int size = jsonArray.size();
                    int index = random.nextInt(size - 1) + 1;
                    JSONObject quiz = (JSONObject) jsonArray.get(index);
                    System.out.println(quiz.get("Q."));
                    System.out.println(quiz.get("(a)"));
                    System.out.println(quiz.get("(b)"));
                    System.out.println(quiz.get("(c)"));
                    System.out.println(quiz.get("(d)"));
                    System.out.println("Type the correct answer");
                    Scanner input = new Scanner(System.in);
                    String userAns = input.nextLine();
                    System.out.println("\n");
                    if (userAns.equals(quiz.get("Ans."))) {
                        count++;
                    }
                }
                System.out.println("Your Score is " + count + " out of 5");
                break;

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
