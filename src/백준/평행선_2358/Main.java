package 백준.평행선_2358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int countResult = 0;
    static int[] memory = new int[]{0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            String a = br.readLine();
            System.out.println(a);
            Pattern aa = Pattern.compile("(\\d)\\s(\\d)");
            Matcher m = aa.matcher(a);

            if (m.matches()) {
                int xNumber = Integer.parseInt(m.group(1));
                int yNumber = Integer.parseInt(m.group(2));
                arr.get(xNumber).set(yNumber,arr.get(xNumber).get(yNumber)+ 1);
            }


        }





        for (int i = 0; i < count; i++) {
            int hangCount = 0;
            int yeolCount = 0;
            for (int j = 0; j < count; j++) {
                hangCount += arr.get(i).get(j);
                yeolCount += arr.get(j).get(i);
            }
            countResult += (getWayCount(hangCount) + getWayCount(yeolCount));
        }
        System.out.println(countResult);
        br.close();

    }

    private static int getWayCount(int hangCount) {
        if (hangCount == 0) return 0;
        if (hangCount == 1) return 0;
        if (hangCount == 2) return 1;

        if (memory[hangCount] != 0) {
            return memory[hangCount];
        } else {
            int a = getWayCount(hangCount-1) + 1;
            memory[hangCount] = a;
            return a;
        }
    }
}
