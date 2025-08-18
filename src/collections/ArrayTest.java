package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayTest {
    public static void main(String[] args) {
        int[ ] arr = {1, 2};
        int[ ] arr2 = new int[] {1,2,3};
        int [ ] arr3 = IntStream.range(0,3).toArray();
        String [] a = new String[]{"a","b","c"};


        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(a));
        for(String ar : a) {
            System.out.println(ar);
        }
        Arrays.stream(arr3).forEach(System.out::println);


        int [] b = {1,2,3};
        List<Integer> list3 = Arrays.stream(b).boxed().toList();



        Integer [] intArr = new Integer[]{1,2,3};
        // 베열 리스트로 변환하기
        List<Integer> list = Arrays.asList(intArr);
        System.out.println(list);

        List<Integer> list2 = Stream.of(intArr).toList();
        System.out.println(list2);


        int [] c = {1,2,3};
        IntStream list4 = IntStream.of(c);//   Arrays.stream(c);
        List<Integer> list5 = list4.boxed().toList();



    }
}
