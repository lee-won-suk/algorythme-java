package 백준.단어정렬1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String [ ] arr = new String[count];

        for (int i = 0; i < count; i++) {
            arr[i] = (br.readLine());
        }

        Arrays.sort(arr, new Comparator<>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        Set<String> set = new LinkedHashSet<>(Arrays.asList(arr));

        for (String s : set) {
            System.out.println(s);
        }
        br.close();
    }
}
