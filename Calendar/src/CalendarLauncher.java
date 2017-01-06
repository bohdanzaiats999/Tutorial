import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;



public class CalendarLauncher {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        myCalendar.show(2017, 1);
        myCalendar.show();

    }
}