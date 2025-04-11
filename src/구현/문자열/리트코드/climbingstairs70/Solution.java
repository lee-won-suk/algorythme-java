package 구현.문자열.리트코드.climbingstairs70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<Integer> list = new ArrayList<>(Arrays.asList(1, 2)) ;

    //탑다운 메모이제이션
    /*public int climbStairs(int n) {
        if (n >= 3 && list.size() < n) {
            list.add(n - 1, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return list.get(n - 1);
    }
*/

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            list.add(list.get(i-1)+list.get(i-2));
        }
        return list.get(n-1);
    }

public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(5));
}
}
