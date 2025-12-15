package 자료구조.스택.스택228278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int order = Integer.parseInt(br.readLine());
        IntStack intStack = new IntStack();
        for (int i = 0; i < order; i++) {
            String[] input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            int answer = 0;
            switch (cmd) {
                case 1:
                    intStack.push(Integer.parseInt(input[1]));
                    break;
                case 2:
                    answer = intStack.pop();
                    break;
                case 3:
                    answer = intStack.size();
                    break;
                case 4:
                    answer = intStack.isEmpty();
                    break;
                case 5:
                    answer = intStack.peek();
                    break;
            }
            if (cmd != 1) {
                sb.append(answer).append('\n');
            }

        }
        System.out.println(sb);
    }

    static class IntStack {
        private final Deque<Integer> stack = new ArrayDeque<>();
        public void push(int number) {
            stack.push(number);
        }
        public int pop() {
            return stack.isEmpty() ? -1 : stack.pop();
        }
        public int isEmpty() {
            return stack.isEmpty() ? 1 : 0;
        }
        public int size() {
            return stack.size();
        }
        public int peek() {
            return stack.isEmpty() ? -1 : stack.peek();
        }
    }
}
