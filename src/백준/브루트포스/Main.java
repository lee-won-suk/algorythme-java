package 백준.브루트포스;

import java.io.*;
import java.util.*;

public class Main{
    static Long a,b;
    static int resultCount = 0;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(0);

        System.out.println(resultCount);
    }
    static void dfs(long num){
        if(num > b) return;
        if(num >=a && num !=0) {
            resultCount++;
        }
        dfs(num*10 +4);
        dfs(num*10 +7);
    }
}
