package 구현.문자열.리트코드.두배열의교집합349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       // nums1.
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set.retainAll(set2);
        System.out.println(set);
        int[] res = set.stream().mapToInt(i -> i).toArray();
        return res;
    }

}