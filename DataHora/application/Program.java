package DataHora.application;

import java.text.ParseException;
// 3
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Program {
  public static void main(String[] args) throws ParseException {

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyyy HH:mm");

    // // Date now
    LocalDate date = LocalDate.now();
    LocalDateTime dateTime = LocalDateTime.now();
    Instant instantDate = Instant.now();

    String dateFormat = date.format(format);
    String dateTimeFormat = dateTime.format(formatDateTime);

    System.out.println(date);
    System.out.println(dateTime);
    System.out.println(instantDate);
    System.out.println(dateFormat);
    System.out.println(dateTimeFormat);

    System.out.println("Day: " + date.getDayOfMonth());
    System.out.println("Month: " + date.getMonth());
    System.out.println("Month Value: " + date.getMonthValue());
    System.out.println("Year: " + date.getYear());
    System.out.println("Plus Year: " + date.plusYears(4));

    // // DUration
    Duration durationBetween = Duration.between(dateTime, dateTime.plusYears(3));

    System.out.println(durationBetween.toDays());

    // Date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Date dateSimpleFormat = simpleDateFormat.parse("16/09/1995");
    Date dateTwo = simpleDateTimeFormat.parse("16/09/1995 22:30:00");

    System.out.println(dateSimpleFormat);
    System.out.println(dateTwo);

    // Date for calendar
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date dateFrom = Date.from(Instant.parse("2021-11-19T16:24:00Z"));

    System.out.println(sdf.format(dateFrom));

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateFrom);
    calendar.add(Calendar.HOUR_OF_DAY, 4);

    dateFrom = calendar.getTime();

    System.out.println(sdf.format(dateFrom));

  }
}
