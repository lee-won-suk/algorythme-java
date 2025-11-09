package 배열;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String a = br.readLine().;
        int [] arr = a.chars().map(Character::getNumericValue)
                .toArray();

        IntSummaryStatistics ns = Arrays.stream(arr).summaryStatistics();

        StringBuilder st = new StringBuilder();
        st.append(ns.getMin());
        st.append(" ");
        st.append(ns.getMax());

        System.out.println(st);

    }
}
