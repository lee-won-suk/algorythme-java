package 백준.구현;


import java.util.*;
import java.io.*;

import static java.util.Arrays.stream;

public class 윷놀이2490{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<3 ; i++) {
            String a = br.readLine();
            System.out.println(convert(Arrays.stream(a.split(" ")).mapToInt(Integer::parseInt).sum()));
            //int c = stream(a.split(" ")).mapToInt(Integer::parseInt).sum();
        }

    }

    static String convert(int number) {
        if(number == 1) {
            return "C";
        }
        if(number == 2) {
            return "B";
        }
        if(number == 3) {
            return "A";
        }
        if(number == 4) {
            return "E";
        }
        return "D";
    }
}
