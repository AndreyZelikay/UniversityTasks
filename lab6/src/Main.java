import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();

        System.out.println("Calendar:");
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("milliseconds:");
        System.out.println(calendar.get(Calendar.MILLISECOND));
        System.out.println("day of year:");
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("day of month:");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("------------------------------------");

        System.out.println("Simple date format:");
        DateFormat df = new SimpleDateFormat("GG", Locale.ENGLISH);
        System.out.println("Era:");
        System.out.println(df.format(calendar.getTime()));

        df = new SimpleDateFormat("ww");
        System.out.println("week of year:");
        calendar.set(Calendar.WEEK_OF_YEAR,7);
        System.out.println(df.format(calendar.getTime()));

        df = new SimpleDateFormat("EEEE");
        System.out.println("day of week:");
        System.out.println(df.format(calendar.getTime()));

        df = new SimpleDateFormat("m");
        System.out.println("minutes:");
        System.out.println(df.format(calendar.getTime()));

        df = new SimpleDateFormat("S");
        System.out.println("milliseconds:");
        System.out.println(df.format(calendar.getTime()));
        System.out.println("------------------------------------");

        System.out.println("Formatter:");
        System.out.println("First two numbers of year:");
        System.out.format("%tC",calendar.getTime());

        System.out.println("month/day/year:");
        System.out.format("%tD",calendar.getTime());

        System.out.println("nanoseconds:");
        System.out.format("%tN",calendar.getTime());

        System.out.println("region equivalent:");
        System.out.format("%tp",calendar.getTime());

        

    }
}
