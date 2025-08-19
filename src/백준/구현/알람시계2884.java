package 백준.구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알람시계2884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute >= 45) {
            System.out.printf("%d %d", hour, minute - 45);
        }

        if (minute < 45) {
            if (hour == 0) {
                hour = hour + 23;
            } else {
                hour -= 1;
            }
            minute = minute + 15;
            System.out.printf("%d %d", hour, minute);
        }
        br.close();


    }

}