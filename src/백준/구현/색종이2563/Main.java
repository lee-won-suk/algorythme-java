package 백준.구현.색종이2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {
    public static class Square{
        int leftX, downY;
        public Square(int leftX, int downY) {
            this.leftX = leftX;
            this.downY = downY;
        }

        public int calculate(Square anotherSquare) {
            int totalX = 10 - abs(this.leftX - anotherSquare.leftX);
            int totalY = 10 - abs(this.downY - anotherSquare.downY);
            if (totalX >=10 || totalY >=10) {
                return 0;
            }
            return totalX * totalY;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Square[] squares = new Square[N];

        int totalResult = N*100;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            squares[i] = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i; j < N; j++) {
                totalResult -= squares[i].calculate(squares[j]);
            }
        }
        System.out.println(totalResult);
    }
}
