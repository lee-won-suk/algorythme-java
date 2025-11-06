package 백준.브루트포스.숫자재배치;

import java.io.*;
import java.util.*;

public class Main {
    static int resultCount = 0;
    static int [] a;//A 숫자 배열
    static int b = 0;
    static boolean [ ] visited;
    public static void main(String [] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String aStr = st.nextToken();  
        b = Integer.parseInt(st.nextToken());
        //하나씩 잘라서 배열로 만들기
        a = new int[aStr.length()];
        visited = new boolean[aStr.length()];
        for( int i = 0; i<aStr.length(); i++) {
            a[i] = aStr.charAt(i) - '0';
        }
        
        makeNumber(0,0);
        System.out.println(resultCount);
        
    }
    static void makeNumber(int depth, int number) {
        if( a.length == depth) {
            if(number < b) {
                resultCount = Math.max(number,resultCount);
            } 
            
            if(resultCount ==b || resultCount ==0){
                resultCount = -1;
            }
            
            return;
        }            
        
        for (int i =0; i < a.length; i++) {
            //방문했으면 넘어감
            if(visited[i]) {
                continue;
            }
            if(depth==0&&a[i]==0) {
                continue;
            }
            visited[i] = true;
            makeNumber(depth+1,number*10 + a[i]);
            visited[i] = false;
            
        }
        
    }
}



