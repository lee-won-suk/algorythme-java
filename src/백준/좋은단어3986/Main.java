package 백준.좋은단어3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < wordNumber; i++) {
            String word = br.readLine();
            wordCheck(word);
        }
        System.out.println(count);
        br.close();
    }

    private static void wordCheck(String word) {
        if (word.length() % 2 == 1) {
            return;
        }
        Character firstWord = word.charAt(0);
        Stack<Character> stack = new Stack<>();
        stack.push(firstWord);
        for (int i = 1; i < word.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(word.charAt(i));
            } else if(word.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(word.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            count++;
        }
    }
}
