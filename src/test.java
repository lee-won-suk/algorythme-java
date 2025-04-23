import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        System.out.println(a+b+c);
        System.out.println((a+b+c)/3);
        System.out.println((a+b+c) -(a+b+c)/3);


    }
}