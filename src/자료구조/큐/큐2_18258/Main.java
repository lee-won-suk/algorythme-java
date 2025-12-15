package 자료구조.큐.큐2_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        IntQueue intQueue = new IntQueue();

        for (int i = 0; i < count; i++) {
            String [] input = br.readLine().split(" ");
            String cmd = input[0];
            int answer = 0;

            switch(cmd) {
                case "push":
                    intQueue.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    answer = intQueue.poll();
                    break;
                case "size":
                    answer = intQueue.size();
                    break;
                case "empty":
                    answer = intQueue.isEmpty();
                    break;
                case "front":
                    answer = intQueue.front();
                    break;
                case "back":
                    answer = intQueue.back();
                    break;

            }
            if(!cmd.equals("push")) {
                sb.append(answer).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static class IntQueue {
        private Deque<Integer> deque = new ArrayDeque<>();
        public void push(int i) {
            deque.offer(i);
        }

        public int poll() {
            return deque.isEmpty() ?-1 : deque.poll();
        }

        public int size() {
            return deque.size();
        }

        public int isEmpty() {
            return deque.isEmpty() ? 1 : 0;
        }

        public int front() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public int back() {
            return deque.isEmpty() ? -1 : deque.peekLast();
        }
    }
}
