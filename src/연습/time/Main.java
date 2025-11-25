package 연습.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        //localTime -> String
        String nowStr = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(nowStr);
        System.out.println(nowStr.getClass());
        //String -> LocalTime
        LocalTime now2 = LocalTime.parse(nowStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(now2);
        System.out.println(now2.getClass());

    }
}
