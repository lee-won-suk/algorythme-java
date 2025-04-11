package 백준.좋은단어3986;

import java.io.*;

public class GoodWord3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordNumber = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < wordNumber; i++) {
            String a =br.readLine();
            String b = a.substring(0, a.length()/2);
            String c = a.substring(a.length()/2);

            b = b.replaceAll("A","_");
            b = b.replaceAll("B","A");
            b = b.replaceAll("_","B");

            if(b.equals(c)) {
                count++;
            }
        }
        bw.write(count);
        bw.flush();
        bw.close();
        br.close();
    }
}
