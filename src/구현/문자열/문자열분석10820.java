package 구현.문자열;

import java.io.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class 문자열분석10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = "";

        while ((line = br.readLine()) != null) {  // EOF 또는 빈 줄 입력 시 종료
            int[] result = {0, 0, 0, 0};
            for (char a : line.toCharArray()) {
                if (Character.isLowerCase(a)) {
                    result[0]++;
                }
                if (Character.isUpperCase(a)) {
                    result[1]++;
                }
                if (Character.isDigit(a)) {
                    result[2]++;
                }
                if (a == ' ') {
                    result[3]++;
                }
            }
            bw.write(stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            bw.flush();
        }

        bw.close();
        br.close();

    }
}
