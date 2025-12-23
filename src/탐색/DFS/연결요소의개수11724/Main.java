package 탐색.DFS.연결요소의개수11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int connectedCount =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int nodeCounts = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int[] visited = new int[nodeCounts+1];
        Deque<Integer> stack = new ArrayDeque<>();
        //인접 리스트 만들기
        List<Integer>[] graph = new ArrayList[nodeCounts+1];
        for(int i = 0 ; i<=nodeCounts; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode].add(endNode);
            graph[endNode].add(startNode);

        }
        //dfs를 한번 하고, 모두 방문할때까지 진행

        for(int j = 1; j<=nodeCounts;j++) {
            if(visited[j]==0) {
                dfs(graph,visited,stack,j);
                connectedCount++;
            }
        }
        //시작점을 넣음
        System.out.println(connectedCount);
    }

    private static void dfs(List<Integer>[] graph, int [] visited, Deque<Integer> stack, int startPoint) {
        visited[startPoint] = 1;
        for(int nextNode : graph[startPoint]) {
            if(visited[nextNode]==0) {
                dfs(graph, visited, stack, nextNode);
            }
        }
    }
}
