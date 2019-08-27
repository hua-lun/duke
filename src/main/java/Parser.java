import java.util.ArrayList;

public class Parser {

    public void goodBye() {
        System.out.println("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public void callList(ArrayList<TaskList> array) {
        TaskList.printList(array);
    }

    public void callDone(String word, ArrayList<TaskList> array) {
        String arr1[] = word.split(" ");
        int taskNum = Integer.parseInt(arr1[1]);
        TaskList.markAsDone(taskNum, array);
    }

    public void callTodo(int num, String word,
                         ArrayList<TaskList> array) {
        TaskList todoT = new Todo(num, "[✗]", word, "todo");
        todoT.addList(todoT, array, num);
    }

    public void callEvent(String word, int num,
                          ArrayList<TaskList> array) {
        String arr2[] = word.split("/");
        TaskList eventT = new Event(num, "[✗]", arr2[0], "event", arr2[1]);
        eventT.addList(eventT, array, num);
    }

    public void callDeadline(String word, int num,
                             ArrayList<TaskList> array) {
        String arr3[] = word.split("/");
        TaskList deadlineT = new Deadline(num, "[✗]", arr3[0], "deadline", arr3[1]);
        deadlineT.addList(deadlineT, array, num);
    }

    public void callDelete(String word, ArrayList<TaskList> array) {
        String arr4[] = word.split(" ");
        int taskNum = Integer.parseInt(arr4[1]);
        TaskList forDelete = array.get(taskNum - 1);
        forDelete.deleteTask(forDelete, array);

        int size = array.size();

        for(int i = 0; i < size; i++) {
            TaskList t = array.get(i);
            int current = t.getTaskNumber();
            String type = t.getType();

            if(current != i + 1) {
                if(type.equals("todo")) {
                    TaskList t1 = new Todo(i + 1, t.getTaskCheck(),
                            t.getTaskName(), "todo");
                    array.set(i, t1);
                } else if(type.equals("event")) {
                    TaskList t2 = new Event(i + 1, t.getTaskCheck(),
                            t.getTaskName(), "event", t.getAB());
                    array.set(i, t2);
                } else {
                    TaskList t3 = new Deadline(i + 1, t.getTaskCheck(),
                            t.getTaskName(), "deadline", t.getAB());
                    array.set(i, t3);
                }
            }
        }
    }
}
