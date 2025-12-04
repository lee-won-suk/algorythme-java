package 그래프.다익스트라.연습;

import java.util.*;


public class Main {


    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {

        int n = 5;

        //인접리스트 구하기
         List<Integer>[] a  = new ArrayList[6];
         for(int i =0;i<a.length;i++) {
             a[i] = new ArrayList<>();
         }
        a[1].add(2);
        a[1].add(3);
        a[2].add(4);
        a[3].add(4);
        a[4].add(5);

        //최단거리 배열
        int [] minArr = new int [n+1];
        Arrays.fill(minArr, INF);
        minArr[1] =0; //시작노드 0으로 초기화

        //pq, 노드번호, 현재까지의 거리. 현재까지의 거리를 비교해서 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{1,0}); //시작노드, 거리0

        while(!pq.isEmpty()) {
            int [] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            //이전 갱신정보 무시
            if(currentDistance > minArr[currentNode]) continue;
            //현재노드와 다음노드 비교
            for(int nextNode : a[currentNode]) {
                if(minArr[nextNode]> minArr[currentNode]+1) {
                    minArr[nextNode] = minArr[currentNode]+1;
                    pq.add(new int[]{nextNode, minArr[nextNode]});// 더짧은 거리가 나오면 또 집어넣음
                }
            }
        }

        System.out.println(Arrays.toString(minArr));

    }
}
