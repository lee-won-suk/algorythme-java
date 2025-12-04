package 그래프.플로이드워셜.경로찾기11403;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        //인접 행렬 만들기
        int [][] intArr = new int [nodeCount][nodeCount];
        for(int i =0;i<nodeCount;i++) {

            int [] nodeArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            for(int j =0; j<nodeCount; j++) {
                intArr[i][j] = nodeArr[j];
            }
        }

        for(int k=0; k<nodeCount; k++) {
            for(int s=0; s<nodeCount; s++) {
                for(int e=0; e<nodeCount; e++) {
                    if(intArr[s][k]==1 && intArr[k][e]==1) {
                        intArr[s][e]=1;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int l=0; l<nodeCount; l++){
            for(int m=0; m<nodeCount; m++){
                sb.append(intArr[l][m] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
