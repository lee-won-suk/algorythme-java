
package 그래프.유니온파인드.집합의표현1717;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class Main {
    public static int [] inArray;
    public static void  main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //진입차수 배열
        inArray = IntStream.range(0,n+1).toArray();

        for(int i =0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            if(flag == 0) {
                unionFind(firstNode, secondNode);
            } else {
                sb.append(find(firstNode) == find(secondNode) ? "YES\n" : "NO\n");
            }
        }
        System.out.println(sb);
    }

    public static void unionFind(int firstNode, int secondNode) {
        //find로 찾은 두값을 비교해서 작은값을 대표노드로 바꿈
        int firstRootNode = find(firstNode);
        int secondRootNode = find(secondNode);

        if(firstRootNode == secondRootNode) return;
        if(firstRootNode < secondRootNode) {
            inArray[secondRootNode] = firstRootNode;
        } else {
            inArray[firstRootNode] = secondRootNode;
        }
    }

    public static int find(int node) {
        //만약 키값과 인덱스가 동일하면 그걸 그대로 리턴
        if(node == inArray[node]) return node;
        return inArray[node] = find(inArray[node]);
    }
}


