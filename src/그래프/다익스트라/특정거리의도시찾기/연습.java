package 그래프.다익스트라.특정거리의도시찾기;

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
public class 연습 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeCount = Integer.parseInt(st.nextToken());
    int edgeCount = Integer.parseInt(st.nextToken());
    int mindistance = Integer.parseInt(st.nextToken());
    int startCity = Integer.parseInt(st.nextToken());

    //인접리스트 만들기
    List<Integer> [] graphList = new ArrayList[nodeCount+1];
    for (int i = 0; i <= nodeCount; i++) {
        graphList[i] = new ArrayList<>();
    }

    for( int i=1; i<=edgeCount; i++) {
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        graphList[startNode].add(endNode);
    }

    //최단거리 배열 만들기
    int [] minArr = new int[nodeCount+1];
    Arrays.fill(minArr, Integer.MAX_VALUE);
    minArr[startCity] = 0;
    PriorityQueue <Node> pq = new PriorityQueue<>();
    pq.offer(new Node(startCity,0));

    while(!pq.isEmpty()) {
        Node node = pq.poll();
        int start = node.startNode;
        int distance = node.edge;
        //현재 길이보다 큐의 거리가 크면 넘어간다.
        if(distance > minArr[start] ) continue;
        //minArr[i]+1 <minArr[끝 노드] 이면 갱신하고 걔를 다시 큐에 넣는다.
        List<Integer> list = graphList[start];

        for(int tempEndNode : list) {
            //최단거리가 현재 배열의 갑보다 작으면 갱신
            if(minArr[start]+1< minArr[tempEndNode]) {
                minArr[tempEndNode] = minArr[start]+1;
                pq.offer(new Node(tempEndNode, minArr[tempEndNode]));
            }
        }
    }
    List<Integer> result = new ArrayList<>();
    //배열에서 k와 같은 값 도시번호 뽑기
    for(int i = 1; i < minArr.length; i++ ) {
        if(minArr[i] == mindistance) {
            result.add(i);
        }
    }
    if(result.isEmpty()) {
        System.out.println(-1);
    } else {
        Collections.sort(result);
        for(int item : result) {
            System.out.println(item);
        }
    }

}

public static class Node implements Comparable<Node>{
    int startNode;
    int edge;
        public Node(int startNode,int edge) {
        this.startNode = startNode;
        this.edge = edge;
    }


    @Override
    public int compareTo(Node o) {
        return this.edge - o.edge;
    }
}
}