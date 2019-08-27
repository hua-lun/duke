import java.util.ArrayList;
import java.util.Scanner;
public class Ui {

    public void run(Scanner sc, ArrayList<TaskList> array, int num) {
        Parser p = new Parser();
        while (sc.hasNext()) {
            String word = sc.nextLine();
            while (!word.equals("bye") && !word.equals("list") &&
                    !word.contains("done") && !word.contains("todo") &&
                    !word.contains("event") && !word.contains("deadline") &&
                    !word.contains("delete")) {
                System.out.println("☹ OOPS!!! I'm sorry, " +
                        "but I don't know what that means :-(");
                word = sc.nextLine();
            }
            while(word.equals("todo") || word.equals("event") ||
                    word.equals("deadline")) {
                System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                word = sc.nextLine();
            }
            if (word.equals("bye")) {
               p.goodBye();
            } else if (word.equals("list")) {
               p.callList(array);
            } else if (word.contains("done")) {
                p.callDone(word, array);
            } else if (word.contains("todo")) {
                p.callTodo(num, word, array);
                num++;
            } else if (word.contains(("event"))) {
                p.callEvent(word, num, array);
                num++;
            } else if (word.contains("deadline")) {
                p.callDeadline(word, num, array);
                num++;
            } else if (word.contains("delete")) {
                p.callDelete(word, array);
            }
            System.out.println("What can I do for you?");
        }
    }
}
