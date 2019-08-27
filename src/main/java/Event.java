public class Event extends TaskList {
    private String at;

    public Event(int taskNumber, String taskCheck,
                 String taskName, String type, String t) {

        super(taskNumber, taskCheck, taskName, type);
        at = t;
    }

    public String getAB() {
        return at;
    }

    @Override
    public String toString() {
        return Integer.toString(getTaskNumber()) + ".[E]" +
                getTaskCheck() + " " + getTaskName() + at;
    }
}
