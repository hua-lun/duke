/**
 * This is the DateAndTime class. It is used to convert input date and time to the
 * correct format.
 */
public class DateAndTime {
    private String dateTime;
    private String date;
    private String time;

    public DateAndTime(String s) {
        dateTime = s;
        String[] arr = s.split(" ");
        date = arr[1];
        time = arr[2];
    }

    /**
     * <p>
     *     convertDate is used to convert the input date to day month year format.
     * </p>
     * @return formatted date
     */

    public String convertDate() {
        String[] arr = date.split("/");
        System.out.println(arr[0]);
        String day = arr[0];
        String month = arr[1];
        String year = arr[2];
        if(month.equals("01")) {
            month = "January";
        } else if(month.equals("02")) {
            month = "February";
        } else if(month.equals("03")) {
            month = "March";
        } else if(month.equals("04")) {
            month = "April";
        } else if(month.equals("05")) {
            month = "May";
        } else if(month.equals("06")) {
            month = "June";
        } else if(month.equals("07")) {
            month = "July";
        } else if(month.equals("08")) {
            month = "August";
        } else if(month.equals("09")) {
            month = "September";
        } else if(month.equals("10")) {
            month = "October";
        } else if(month.equals("11")) {
            month = "November";
        } else if(month.equals("12")) {
            month = "December";
        }
        date = day + " " + month + " " + year;
        return date;
    }

    /**
     * <p>
     *     convertTime is used to convert the input time to a.m. or p.m. format.
     * </p>
     * @return formatted time
     */

    public String convertTime() {
       String[] arr = time.split("");
       String hour = arr[0] + arr[1];
       String min = arr[2] + arr[3];
       int h = Integer.parseInt(hour);
       if(h < 12) {
           time = hour + "." + min + "a.m.";
       } else {
           int changeHour = Integer.parseInt(hour) - 12;
           time = changeHour + "." + min + "p.m.";
       }
       return time;
    }

    @Override
    public String toString() {
        return date + ", " + time;
    }
}
