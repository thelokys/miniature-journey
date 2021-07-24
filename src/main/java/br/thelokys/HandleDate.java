package br.thelokys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * This class show ways to format dates
 */
public class HandleDate {
    public static void main(String[] args) {

        var today = LocalDate.now();
        System.out.print("-> " + today);

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(" -> " + today.format(formatter));

        var now = LocalDateTime.now();
        System.out.print("-> " + now);

        var formatterWithHour = DateTimeFormatter
                .ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(" -> " + now.format(formatterWithHour));

        var formatterShort = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("short -> " + now.format(formatterShort));

        var formatterMedium = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("medium -> " + now.format(formatterMedium));

        var formatterWithLocale = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(Locale.CHINA);
        System.out.println(
                "Locale China -> " + now.format(formatterWithLocale));

        var formatterWithCustomLocale = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(new Locale("pt", "br"));
        System.out.println(
                "Custom locale -> " + now.format(formatterWithCustomLocale));

        var minusFiveHoursFromNow = now.minusHours(5);
        System.out.println(
                "Minus five hours from now -> " + minusFiveHoursFromNow);

        var plusFiveHoursFromNow = now.plusHours(5);
        System.out.println(
                "Plus five hours from now -> " + plusFiveHoursFromNow);

    }
}
