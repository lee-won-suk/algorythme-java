package 배열;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTest {
    public static void main(String[] args) {
        //배열 직접 초기화
        int [] arr= {1,2,3};
        String [] arr2 = {"A","B","C"};
        Arrays.fill(arr,5);
        Arrays.fill(arr2, "");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        arr = IntStream.range(0,3).toArray();
        System.out.println(Arrays.toString(arr));
        Arrays.setAll(arr,i -> i*2);
        System.out.println(Arrays.toString(arr));

        //1차원 배열 복사
        int [] copyArr = Arrays.copyOf(arr, arr.length);
        System.out.println("copyarr :" + Arrays.toString(copyArr));
        int [] copyArr2 = Arrays.copyOfRange(arr,0,2);
        System.out.println("copyarr2 :" + Arrays.toString(copyArr2));
        int[] arr3 = IntStream.of(1,2,3,4,5).toArray();
        int [] copyArr3 = new int[5];
        System.arraycopy(arr3,0,copyArr3,0,copyArr3.length);
        System.out.println("copyarr3 :" + Arrays.toString(copyArr3));
        int[] array4 = Arrays.stream(arr3).toArray();
        System.out.println("array4 :" + Arrays.toString(array4));


        //2차원 배열 복사
        int [][] arr2d= {{1,2,},{3,4}};
        int [][] copy2arr = new int[arr2d.length][];
        //for문 + clone
        for(int i =0;i<arr2d.length;i++) {
            copy2arr[i] = arr2d[i].clone();
        }
        System.out.println("2차원 배열 복사 :" + Arrays.deepToString(copy2arr));
        copy2arr[0][0] = 9;
        System.out.println("원본 배열 :" + Arrays.deepToString(arr2d));
        System.out.println("복사 배열 :" + Arrays.deepToString(copy2arr));

        int[][] copy2arr2  = Arrays.stream(arr2d).map(ints -> ints.clone()).toArray(value -> new int[value][]);
        System.out.println("2차원 배열 복사2 :" + Arrays.deepToString(copy2arr2));

        //배열의 최대값, 최소값
        int [] arr5 = IntStream.range(0,5).toArray();
        int min = Arrays.stream(arr5).min().getAsInt();
        int max = Arrays.stream(arr5).max().getAsInt();
        System.out.println("min :" + min + ", max :" + max);
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(arr5).summaryStatistics();
        System.out.println("min :" + intSummaryStatistics.getMin() + ", max :" + intSummaryStatistics.getMax()
                + ", sum :" + intSummaryStatistics.getSum() + ", avg :" + intSummaryStatistics.getAverage()
                + ", count :" + intSummaryStatistics.getCount());

        //배열의 정렬
        int [] sortArr = IntStream.of(1,4,3,2,5).toArray();
        //오름차순
        Arrays.sort(sortArr);
        System.out.println(Arrays.toString(sortArr));
        //내림차순
        Integer [] boxedArr = Arrays.stream(sortArr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(boxedArr));

        //stream을 이용한 방법
        sortArr = Arrays.stream(sortArr).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(sortArr));

        //문자열을 int 배열로 변환하는 방법
        String str = "12345";
        int[] intArr =Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println("string값 int 변환 :" + Arrays.toString(intArr));

        intArr = str.chars().map(Character::getNumericValue).toArray();

    }



}
