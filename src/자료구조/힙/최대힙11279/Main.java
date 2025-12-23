package 자료구조.힙.최대힙11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < count; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number ==0) {
                sb.append(maxHeap.isEmpty() ? 0 : maxHeap.poll()).append('\n');
            } else {
                maxHeap.offer(number);
            }
        }
        System.out.print(sb);
    }
}
