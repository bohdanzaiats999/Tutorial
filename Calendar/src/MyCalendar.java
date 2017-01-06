import java.time.DayOfWeek;
import java.time.Year;
import java.time.MonthDay;


public class MyCalendar {

    public void show() {
        show(Year.now().getValue(), MonthDay.now().getMonthValue());
    }

    public void show(int year, int month) {
        // Determining the location of the first day of the month
        int offset = MonthDay.of(month, 1).atYear(year).getDayOfWeek().getValue() - 1;

        // The last day of the month
        int lastday = MonthDay.of(month, MonthDay.now().getDayOfMonth()).atYear(year).lengthOfMonth();

        // Stabilization table
        if (offset >= 7) {
            offset -= 7;
        }

        System.out.println("  Пн Вт Ср Чт Пт Сб Нд");

        // Сoordinates of the beginning of the month
        for (int i = 0; i < offset; i++)
            System.out.print("   ");

        // Formation of the table
        for (int i = 1; i <= lastday; i++) {
            DayOfWeek dayOfWeek = MonthDay.of(month, i).atYear(year).getDayOfWeek();
            // Output weekend red
            if (((dayOfWeek  == DayOfWeek.SUNDAY) || ((dayOfWeek  == DayOfWeek.SATURDAY)) & i != MonthDay.now().getDayOfMonth())) {
                System.out.print((char) 27 + "[31m" + String.format("%3d", i) +
                        (dayOfWeek  == DayOfWeek.SUNDAY  ? "\n" : "") + (char) 27 + "[0m");
            }
            // Output day given user in blue
            else if (month == MonthDay.now().getMonth().getValue() && i == MonthDay.now().getDayOfMonth()) {
                System.out.print((char) 27 + "[34m" + String.format("%3d", i) +
                        (dayOfWeek  == DayOfWeek.SUNDAY  ? "\n" : "") + (char) 27 + "[0m");
            }
            // Output weekdays gray
            else {
                System.out.print(String.format("%3d", i));
            }
        }
        System.out.println("\n");
    }
}

