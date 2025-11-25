package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static class TrafficLight {
        int position, red, grean;

        public TrafficLight(int position, int red, int grean) {
            this.position = position;
            this.red = red;
            this.grean = grean;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int currentTimeCount = 0;
        int currentDistance = 0;
        //신호등 입력 받기
        TrafficLight[] trafficLights = new TrafficLight[nCount];
        for (int i = 0; i < nCount; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());//위치
            int red = Integer.parseInt(st.nextToken());//빨간색
            int grean = Integer.parseInt(st.nextToken()); // 초록색 지속시간
            trafficLights[i] = new TrafficLight(position, red, grean);
        }


        for (TrafficLight trafficLight : trafficLights) {
            //신호등 위치만큼 이동
            currentTimeCount += trafficLight.position - currentDistance;
            currentDistance = trafficLight.position;
            //현재상태 체크
            int cycle = trafficLight.red + trafficLight.grean;
            int colorMode = currentTimeCount % cycle;
            if (colorMode < trafficLight.red ) {
                currentTimeCount += (trafficLight.red - colorMode);
            }

        }

        //마지막 신호등
        currentTimeCount += distance - currentDistance ;
        System.out.println(currentTimeCount);
        }
}