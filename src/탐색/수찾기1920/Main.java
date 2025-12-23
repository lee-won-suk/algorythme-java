package 탐색.수찾기1920;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .sorted().toArray();
        int tryCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<tryCount; i++) {
            int targetNumber = Integer.parseInt(st.nextToken());
            int answer = binarySearch(targetNumber, array, 0, arrayLength-1);
            sb.append(answer).append('\n');
        } 
        System.out.println(sb);
    }
    
    public static int binarySearch(int targetNumber, int [] array, int start, int end) {
        while(start <= end) {
            int middleIndex = (start + end)/2;
            //중간값과 같을 경우 리턴
            if (array[middleIndex] == targetNumber)  {
                return 1;
            }
            //타겟이 더 큰 경우
            if(array[middleIndex] < targetNumber ) {
                start = middleIndex +1;
            }
            if(array[middleIndex] > targetNumber ) {
                end = middleIndex -1;
            }

        }
        return 0;
    }
}
