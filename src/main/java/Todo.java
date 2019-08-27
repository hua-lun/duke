public class Todo extends TaskList {

    public Todo(int taskNumber, String taskCheck,
                String taskName, String type) {

        super(taskNumber, taskCheck, taskName, type);
    }

    public String getAB() {
        return "-";
    }

    @Override
    public String toString() {
        return  Integer.toString(getTaskNumber()) + ".[T]" +
                getTaskCheck() + " " + getTaskName();
    }
}
