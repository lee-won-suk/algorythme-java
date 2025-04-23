package 백준.평행선_2358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();

//x,y를 map으로 따로 두는 아이디어
        for (int i = 0; i < count; i++) {

            String a = br.readLine();
            System.out.println(a);
            int [] aa = Arrays.stream(a.split(" ")).mapToInt(Integer::parseInt).toArray();

            int xNumber = aa[0];
            int yNumber = aa[1];



            System.out.println("xNumber : "+xNumber);
            System.out.println("yNumber:"+yNumber);

            if (xMap.containsKey(xNumber)) {
                xMap.put(xNumber, xMap.get(xNumber) + 1);
            } else {
                xMap.put(xNumber, 1);
            }

            if (yMap.containsKey(yNumber)) {
                yMap.put(yNumber, yMap.get(yNumber) + 1);
            } else {
                yMap.put(yNumber, 1);
            }


        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result++;
            }
        }

        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            if (entry.getValue() >= 2) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}





