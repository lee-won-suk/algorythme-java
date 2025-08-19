package 백준.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class 알람시계2884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H m");
        LocalTime a = LocalTime.of(hour, minute);
        a = a.minusMinutes(45);
        System.out.println(a.format(formatter));
        br.close();

    }

}