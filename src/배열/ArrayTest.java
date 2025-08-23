package 배열;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int [] {1,2,3};
        int [] arr2 = Arrays.stream(new int[]{1,2,3}).toArray();
        int [] arr3 = IntStream.range(0,5).toArray();
        String [] a = {"a", "b", "c"};
        System.out.println(Arrays.toString(arr3));

        List<Integer> list = IntStream.of(arr3).boxed().toList();
        List<Integer> list2 = Arrays.stream(arr2).boxed().toList();
        List<String> list3 = Arrays.stream(a).toList();


        Map<String,String> map = IntStream.range(0, a.length)
                        .boxed()
                                .collect(Collectors.toMap(
                                        key -> a[key],
                                        String::valueOf

                                ));
        System.out.println("map = " + map);


        List<String> list7 = Arrays.stream(a).collect(Collectors.toList());
        list7.add("test");
        System.out.println(list7);


        Set<String> set = Arrays.stream(a).collect(Collectors.toSet());
        Set<String> set2 = new HashSet<>(Arrays.asList(a));


    }
}
