package 프로그래머스;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static int[] memo = new int[100];

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

// 1. toArray() - 배열 선언과 동시에 할당
        String[] arr = list.toArray(new String[0]); // ["a", "b", "c"]
        System.out.println(Arrays.toString(arr));
    }




}
