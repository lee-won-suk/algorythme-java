package 백준.학생인기도측정25325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] arr = new String[count];
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] data = br.readLine().split(" ");

        for (int i = 0; i < count; i++) {
            arr[i] = data[i];
            map.put(arr[i], 0);
        }

        for (int i = 0; i < count; i++) {
            String[] personalLikeArray = br.readLine().split(" ");
            for (int j = 0; j < personalLikeArray.length; j++) {
                map.put(personalLikeArray[j], map.get(personalLikeArray[j]) + 1);
            }
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (map.get(o1) < map.get(o2)) {
                    return 1;
                }

                if (map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                }
                return -1;
            }
        });

        for (int i = 0; i < count; i++) {
            System.out.println(String.join(" ", arr[i], String.valueOf(map.get(arr[i]))));
        }

        br.close();
    }
}
