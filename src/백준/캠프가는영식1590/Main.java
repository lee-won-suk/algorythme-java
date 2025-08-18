package 백준.캠프가는영식1590;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [ ] arr = br.readLine().split(" ");
        int busCount = Integer.parseInt(arr[0]);// N가지의 버스
        int startTime = Integer.parseInt(arr[1]);//영식이 터미널에 도착하는 시간
        int a = Integer.MAX_VALUE;


            while (busCount-->0) {
                String [ ] arr2 = br.readLine().split(" ");
                int busStartTime = Integer.parseInt(arr2[0]);//버스 시작 시각
                int busDistance = Integer.parseInt(arr2[1]);//간격
                int totalBusCount = Integer.parseInt(arr2[2]);// 버스 대수

                while (busStartTime < startTime && --totalBusCount>0 && busStartTime < a) {
                    busStartTime += busDistance;
                }

                if (busStartTime >= startTime) {
                    a =Math.min(busStartTime, a);
                }

            }
            System.out.println(a == Integer.MAX_VALUE ? -1 : a - startTime);


        br.close();

    }
}
