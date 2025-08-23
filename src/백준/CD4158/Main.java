package 백준.CD4158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       while (true) {
           String [] arr = br.readLine().split(" ");
           int n = Integer.parseInt(arr[0]);
           int m = Integer.parseInt(arr[1]);
           Set<Integer> set = new HashSet<>();
           Set<Integer> set2 = new HashSet<>();
           int count =0;
           if (n == 0 || m == 0) {
               break;
           }
           for (int i = 0; i<n ; i++) {
               set.add(Integer.parseInt(br.readLine()));

           }
           for (int i = 0; i<m ; i++) {
                set2.add(Integer.parseInt(br.readLine()));
           }
           set.retainAll(set2);

           System.out.println(set);

       }
        br.close();
    }
}
