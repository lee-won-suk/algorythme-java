package 그래프.다익스트라;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<Integer> [] graphList;
    static boolean [] visited;
    public static void main(String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int minDistance = Integer.parseInt(st.nextToken());
        int startNum = Integer.parseInt(st.nextToken());

        graphList = new ArrayList [nodeCount+1];
        visited = new boolean [nodeCount+1];
        visited[0] = true;//0번째 제거

        //최단거리 배열
        int [] minArr = new int[nodeCount+1];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        minArr[startNum] = 0;//시작노드 0으로 초기화
        //초기화
        for(int a= 0; a<=nodeCount; a++) {
            List<Integer> aList = new ArrayList<>();
            graphList[a] = aList;
        }

        //인접 리스트 만들기
        for(int i= 1;i<=edgeCount; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            int tempStartNode = Integer.parseInt(t.nextToken());
            int tempEndNode = Integer.parseInt(t.nextToken());
            graphList[tempStartNode].add(tempEndNode);
        }

        //모든 노드가 최소가 될때까지 반복

        //우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, startNum});


        while(!pq.isEmpty()) {
            int [ ] current = pq.poll();
            int distance = current[0];
            int currentNode = current[1];
            //현재 노드와 다음노드간 비교
            //배열을 전체 순회했을때 전체다 true인걸 구하는 방법

            if(visited[currentNode]) continue;
            visited[currentNode] = true;

            for(int endNode :graphList[currentNode]) {
                if (minArr[endNode] > minArr[currentNode] + 1) {
                    minArr[endNode] = minArr[currentNode] + 1;
                    pq.add(new int[]{minArr[endNode], endNode});
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int result = 1; result < minArr.length; result++)
            if(minArr[result] == minDistance) {
                list.add(result);
            }

        if(list.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(list);
            for (int resultNodeNumber :list) {
                System.out.println(resultNodeNumber);
            }
        }



    }





}




