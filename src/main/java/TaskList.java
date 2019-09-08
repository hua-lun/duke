/**
 * This is the abstract class TaskList. This class is used to add and remove tasks from the current list.
 * @author Hua Lun
 */

import java.util.ArrayList;

abstract class TaskList {
    private int taskNumber;
    private String taskCheck;
    private String taskName;
    private String type;

    public TaskList(int i, String tC, String tN, String t) {
        taskNumber = i;
        taskCheck = tC;
        taskName = tN;
        type = t;
    }


    public abstract DateAndTime getAB();

    /**
     * <p>
     *     getTaskNumber is used to retrieve the task number
     * </p>
     * @return the task number
     */


    public int getTaskNumber() {
        return taskNumber;
    }


    /**
     * <p>
     *     getTaskCheck is used to check if the task is done or not
     * </p>
     * @return status of the task
     */

    public String getTaskCheck() {
        return taskCheck;
    }

    /**
     * <p>
     *     getTaskName is used to retrieve the name of the task
     * </p>
     * @return task's name
     */


    public String getTaskName() {
        return taskName;
    }

  
    /**
     * <p>
     *     getTyoe is used to retrieve the type of task given
     * </p>
     * @return task's type
     */

    public String getType() {
        return type;
    }

    /**
     * <p>
     *     changeTaskCheck is used to mark the task as complete
     * </p>
     */


    public void changeTaskCheck() {
        taskCheck = "[✓]";
    }

    /**
     * <p>
     *     printList is used to print out all the task in the list
     * </p>
     * @param a the list of task
     */

    static String printList(ArrayList<TaskList> a) {
        String out = "Here are the tasks in your list:";
        for (TaskList t : a) {
            out = out + "\n" + t;
        }
        return out;
    }


    /**
     * <p>
     *     markAsDone is used to mark the given task as completed
     * </p>
     * @param i the completed task's number
     * @param a the list of task
     */

    static String markAsDone(int i, ArrayList<TaskList> a) {
        String out = "Nice! I've marked this task as done:";
        Statistics s = new Statistics();
        TaskList t = a.get(i - 1);
        String currentTask = t.getTaskName();
        String getType = t.getType();
        TaskList doneTask;
        if(getType.equals("todo")) {
            doneTask = new Todo(i, "[✓]", currentTask,
                    getType);
            a.set(i - 1, doneTask);
            s.addTodoDone();
        } else if (getType.equals("event")) {
            doneTask = new Event(i, "[✓]", currentTask,
                    getType, t.getAB());
            a.set(i - 1, doneTask);
            s.addEventDone();
        } else {
            doneTask = new Deadline(i, "[✓]", currentTask,
                    getType, t.getAB());

            doneTask = new Todo(i, "[✓]", currentTask, getType);
            a.set(i - 1, doneTask);
            s.addDeadlineDone();
        }
        s.addRecords(s);
        return out + "\n" + "[✓] " + currentTask;
    }

    /**
     * <p>
     *     addList adds the new task into the list and saves the list into a text file
     * </p>
     * @param t the newly created TaskList object
     * @param a the list of task
     * @param n task number assigned
     */

    String addList(TaskList t, ArrayList<TaskList> a, int n) {
        String out = "Got it. I've added this task:";
        a.add(t);
        out = out + "\n" + t + "\n" + "Now you have " + Integer.toString(n) +
                " tasks in the list.";

        return out;
    }


    /**
     * <p>
     *     deleteTask removes the task from the list
     * </p>
     * @param t TaskList object that is to be removed
     * @param a the list of task
     */

    String deleteTask(TaskList t, ArrayList<TaskList> a) {
        int taskNumber = t.getTaskNumber();
        a.remove(taskNumber - 1);

        return "Noted. I've removed this task: " + "\n" + t + "\n" +
                "Now you have " + Integer.toString(a.size()) +
                " tasks in the list.";
    }

    /**
     * <p>
     *     toString method to print TaskList object
     * </p>
     * @return task information
     */
    @Override
    public String toString() {
        return Integer.toString(taskNumber) + "." + taskCheck + " " + taskName;
    }
}
