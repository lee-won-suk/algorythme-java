package 그래프.다익스트라;

import java.util.*;

class Node implements Comparable<Node> {
    int vertex, cost;
    Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class DijkstraTrace {
    public static void main(String[] args) {
        int V = 4;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // 무방향 그래프
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 5);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 2, 3, 2);

        dijkstra(graph, 0);
    }

    static void addEdge(List<List<Node>> g, int u, int v, int w) {
        g.get(u).add(new Node(v, w));
        g.get(v).add(new Node(u, w));
    }

    static void dijkstra(List<List<Node>> graph, int start) {
        int V = graph.size();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 더 짧은 거리로 방문했다면 스킵
            if (cur.cost > distance[cur.vertex]) continue;

            System.out.println("현재 노드: " + cur.vertex + ", 거리: " + cur.cost);

            for (Node next : graph.get(cur.vertex)) {
                int newDist = distance[cur.vertex] + next.cost;

                if (newDist < distance[next.vertex]) {
                    System.out.printf("  → 노드 %d 갱신: %d → %d%n", next.vertex, distance[next.vertex], newDist);
                    distance[next.vertex] = newDist;
                    pq.offer(new Node(next.vertex, newDist));
                }
            }
            System.out.println("distance 배열: " + Arrays.toString(distance));
            System.out.println();
        }

        System.out.println("최종 최단 거리 결과:");
        for (int i = 0; i < V; i++)
            System.out.println("0 → " + i + " = " + distance[i]);
    }
}

