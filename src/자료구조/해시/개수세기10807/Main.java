package 자료구조.해시.개수세기10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i =0; i<size; i ++) {
            int number = Integer.parseInt(st.nextToken());
            countMap.put(number, countMap.getOrDefault(number,0) +1);
        }
        int targetNumber = Integer.parseInt(br.readLine());
        System.out.println(countMap.getOrDefault(targetNumber,0));
    }
}
