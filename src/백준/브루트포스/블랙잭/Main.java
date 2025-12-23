package 백준.브루트포스.블랙잭;

import java.io.*;
import java.util.*;
public class Main{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardNumber = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        int answer = 0;
        for(int i= 0; i<cardNumber-2;i++) {
            for(int j= i+1; j<cardNumber-1;j++) { 
                for(int k= j+1; k<cardNumber;k++) { 
                    int sum = arr[i]+arr[j]+arr[k];
                    if(sum >target) continue;
                    if(sum > answer) answer = sum;
            }        
        }
        System.out.println(answer);
        
    }
    }
}
