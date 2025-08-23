package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개미3048 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstAntCount = Integer.parseInt(st.nextToken());
        int secondAntCount = Integer.parseInt(st.nextToken());
        String firstAnts = br.readLine();
        String secondAnts = br.readLine();
        int moveCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(firstAnts).reverse()).append(secondAnts);
        char [] ants = sb.toString().toCharArray();

        //개미의 방향을 저장할 배열
        boolean [] direction = new boolean[firstAntCount + secondAntCount];
        for(int i=0; i<firstAntCount; i++) {
            direction[i] = true; // true는 왼쪽으로 이동
        }
        for(int i= firstAntCount; i<firstAntCount + secondAntCount; i++) {
            direction[i] = false; // false는 오른쪽으로 이동
        }

        for(int t=0; t<moveCount; t++) {
            for(int j=0; j<ants.length-1; j++) {
                if(direction[j] != direction[j+1]) {
                    direction[j] = !direction[j];
                    direction[j+1] = !direction[j+1];

                    char temp = ants[j];
                    ants[j] = ants[j+1];
                    ants[j+1] = temp;
                    j++; //교환한 개미 건너뛰기
                }
            }

        }
        System.out.println(String.valueOf(ants));
    }
}
