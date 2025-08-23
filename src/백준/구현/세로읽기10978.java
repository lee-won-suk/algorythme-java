package 백준.구현;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 세로읽기10978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [][] data = new char[5][];
        for (int i=0;i<5;i++) {
            data[i] =  br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();

        for(int col=0; col<15; col++) {
            for ( int row=0; row<5; row++) {
                if(col < data[row].length) {
                    sb.append(data[row][col]);
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
