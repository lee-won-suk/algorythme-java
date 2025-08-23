package 구현.문자열.리트코드.두배열간거리구하기1385;

import java.util.Arrays;

class Solution2 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for( int a : arr1) {
            if (getCount(arr2, d, a)){
                count++;
            };
        }

        return count;
    }

    private boolean getCount(int[] arr2, int d, int a) {

        int left = 0;
        int right = arr2.length - 1;
        int middle = left + (right - left) / 2;
        while (left <= right) {
            if(Math.abs(a -arr2[middle]) <= d) {
                return false;
            }
            if ( a> arr2[middle]) {
                left = middle +1 ;
            }
            else {
                right = middle -1;
            }
        }
        return true;
    }
}
