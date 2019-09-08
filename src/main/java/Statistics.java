/**
 * This is the Statistics class. It shows the number of tasks that have been completed in the past week.
 * @author Hua Lun
 */

import java.time.LocalDate;
import java.util.Formatter;

public class Statistics {

    static int todoDone = 0;
    static int eventDone = 0;
    static int deadlineDone = 0;
    static String dateStart = "2019-09-06";

    private Formatter statsFile;

    /**
     * <p>
     *     openFile is used to open the specific text file.
     * </p>
     */

    public void openFile() {
        try{
            statsFile = new Formatter("stats.txt");
        } catch (Exception e){
            System.out.println("you have an error");
        }
    }


    /**
     * <p>
     *     addTodoDone adds 1 to the todoDone counter.
     * </p>
     */

    public void addTodoDone() {
        todoDone++;
    }

    /**
     * <p>
     *     addEventDone adds 1 to the eventDone counter.
     * </p>
     */

    public void addEventDone() {
        eventDone++;
    }

    /**
     * <p>
     *     addDeadlineDone adds 1 to the deadlineDone counter.
     * </p>
     */

    public void addDeadlineDone() {
        deadlineDone++;
    }

    /**
     * <p>
     *     resetStats resets all the data collected.
     * </p>
     */

    static void resetStats() {
        todoDone = 0;
        eventDone = 0;
        deadlineDone = 0;
        LocalDate newDate = LocalDate.now();
        dateStart = newDate.toString();
    }

    /**
     * <p>
     *     getsStats provides the number of tasks done for each category.
     * </p>
     * @return statistics of tasks done.
     */

    static String getStats() {
        return "Since " + dateStart + "\n" +
                "You have done: " + "\n" +
                todoDone + " Todo tasks" + "\n" +
                eventDone + " Event tasks" + "\n" +
                deadlineDone + " Deadline tasks";
    }

    /**
     * <p>
     *     addRecords adds all the statistics into the text file.
     * </p>
     */

    public void addRecords(Statistics s) {
        s.openFile();
        StringBuilder sB = new StringBuilder();
        sB.append(dateStart);
        sB.append("\n");
        sB.append(getStats());
        statsFile.format(sB.toString());
        statsFile.close();
    }


}
