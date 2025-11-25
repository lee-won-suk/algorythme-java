package 연습.정규식;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher("nononono12");
        System.out.println(matcher.matches());
/*        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));*/
        System.out.println(matcher.find());
        System.out.println(matcher.find(1));
        matcher.reset("nononono12");
        System.out.println(matcher.find());
        System.out.println(matcher.group());

    }
}
