package 자료구조.해시.숫자카드10815;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Set<Integer> cardMap = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력 받음
        for(int i =0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            cardMap.add(number);
        }
        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j =0; j < count; j++) {
            int number = Integer.parseInt(st.nextToken());
            //숫자를 가지고 있으면 1 없으면 0
            int answer = cardMap.contains(number) ? 1 : 0;
            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}
