package 그래프.위상정렬.줄세우기2252;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNumber = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        List<Integer> [] arr = new ArrayList [count];
        int[] degreeArr = new int[studentNumber];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(arr, new ArrayList<Integer>());
        //초기화
        for(int i = 0 ; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int firstStudent = Integer.parseInt(st.nextToken());
            int secondStudent = Integer.parseInt(st.nextToken());
            arr[firstStudent].add(secondStudent);
            degreeArr[secondStudent]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int a = 0; a<studentNumber; a++){
            if(degreeArr[a]==0){
                q.add(a);
                break;
            }
        }
        

        //인접리스트의 도착 노드를 꺼내서 진입차수배열의 차수 -1
        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");
            for(int a  : arr[node]) {
                degreeArr[a]-=1;
                if(degreeArr[a] ==0) {
                    q.add(a);
                }
            }
        }
        
        System.out.println(sb.toString());
        
}
}
