package 배열.OX퀴즈;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        while(count --> 0) {
            String [] arr = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
            //O의 갯수만 센다.
            int currentCount =0;
            int number = 0;
            for(String a : arr) {
                if(a.equals("O")) {
                    currentCount+=1;
                    number+= currentCount;
                } else {
                    currentCount=0;
                }
            }
            System.out.println(number);
        }
    }
}
