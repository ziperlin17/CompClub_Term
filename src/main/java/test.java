import java.sql.Time;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class test {
    public static void main(String[] args) {
      DateTimeFormatter date_time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
      LocalDateTime now = LocalDateTime.now();
      System.out.println("The current date and time is: " +date_time.format(now.plusHours(2)));
        System.out.println(date_time.format(now).compareTo("2022/11/25 19:27"));
    }
}
