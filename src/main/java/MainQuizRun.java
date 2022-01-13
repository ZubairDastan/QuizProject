import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class MainQuizRun {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to play the quiz,\nEnter '2' to add quiz in the list,\nEnter '3' to update quiz list,\nEnter '4' to see all quiz list,\nEnter '0' to exit");
        int n = scanner.nextInt();

        switch (n){
            case 1:


            case 2:
                AddQuiz add = new AddQuiz();
                add.addQuiz();

            case 3:
                UpdateQuiz update = new UpdateQuiz();
                update.updateQuiz();

            case 4:
                ReadQuiz read = new ReadQuiz();
                read.readQuiz();

            case 0:
                break;

            default:
                System.out.println("Please select a choice.");

        }
    }
}
