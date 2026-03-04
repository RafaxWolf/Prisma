package com.treeaxes.Prisma.Utils;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetTimeNow {

    public GetTimeNow() {
    }


    public static String getFormattedTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy ");
        return now.format(formato);
    }

    public static String getDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(formato);
    }

    public static String getTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formato);
    }
}
