package 연습.stream;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String a = "12345";

        int [][] arr = new int[10][10];
        arr[0] = Arrays.stream(a.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
