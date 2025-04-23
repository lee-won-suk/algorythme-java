package 구현.문자열.리트코드.RepeatedDNAsequences187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> repeatSet = new HashSet<String>();

        for (int i = 0; i <= s.length()-10; i++) {
            String str = s.substring(i, i+10);
            if (!set.add(str)) {
                repeatSet.add(str);
            }
            System.out.println("[" + i + "] " + str);
        }
        return new ArrayList<String>(repeatSet);
    }
}
