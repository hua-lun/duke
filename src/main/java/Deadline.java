public class Deadline extends TaskList {
    private String by;

    public Deadline(int taskNumber, String taskCheck,
                    String taskName, String type, String b) {

        super(taskNumber, taskCheck, taskName, type);
        by = b;
    }

    public String getAB() {
        return by;
    }

    @Override
    public String toString() {
        return Integer.toString(getTaskNumber()) + ".[D]"
                + getTaskCheck() + " " + getTaskName() + by;
    }

}
