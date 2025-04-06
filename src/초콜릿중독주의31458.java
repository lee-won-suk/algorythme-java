
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 초콜릿중독주의31458 {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        String data;
        int reverse = 0;
        int factorial = 0;

        int [] resultArray = new int[count];
        for(int i = 0 ; i< count; i ++) {
            int result = 0;
            Matcher matcher = Pattern.compile("(!*)(\\d+)(!*)").matcher(br.readLine());

           if(matcher.matches()){
               reverse = Optional.ofNullable(matcher.group(1)).map(String::length).orElse(0);
               factorial = Optional.ofNullable(matcher.group(3)).map(String::length).orElse(0);
               result = Integer.parseInt(matcher.group(2));
               if (factorial > 0 ) {
                   result = 1;
               }

               if (reverse % 2 == 1) {
                   result = (reverse(result));
               }

               resultArray[i] = result;
           }

        }

        for(int i = 0 ; i< count; i ++) {
              /*  bw.write(resultArray[i]);
                bw.flush();*/
            System.out.println(resultArray[i]);
        }
        br.close();
        bw.close();
    }

    private static int reverse(int result) {
        if (result == 1) {
         return 0;
        }
        return 1;
    }
}
