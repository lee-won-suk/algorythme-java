import java.util.Arrays;
import java.util.StringTokenizer;

public class 토큰과split비교 {

    static final int COUNT = 10000000;
    static final int LOOP = 10;

    public static void main(String[] args) {
        String input = generateInput();

        // 워밍업 (JIT 영향 줄이기)
        testTokenizer(input);
        testStream(input);

        long tokenizerTime = 0;
        long streamTime = 0;

        for (int i = 0; i < LOOP; i++) {
            tokenizerTime += testTokenizer(input);
            streamTime += testStream(input);
        }

        System.out.println("StringTokenizer avg (ms): " + tokenizerTime / LOOP / 1_000_000);
        System.out.println("Stream avg (ms): " + streamTime / LOOP / 1_000_000);
    }

    private static long testTokenizer(String input) {
        long start = System.nanoTime();

        StringTokenizer st = new StringTokenizer(input);
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return System.nanoTime() - start;
    }

    private static long testStream(String input) {
        long start = System.nanoTime();

        int sum = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        return System.nanoTime() - start;
    }


    private static String generateInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            sb.append(i).append(' ');
        }
        return sb.toString();
    }
}
