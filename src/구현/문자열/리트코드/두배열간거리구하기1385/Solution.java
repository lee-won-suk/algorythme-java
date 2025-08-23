package 구현.문자열.리트코드.두배열간거리구하기1385;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;

        for( int a : arr1) {
            for (int b : arr2) {
                if(Math.abs(a-b) <= d) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}
