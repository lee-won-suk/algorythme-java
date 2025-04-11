package 구현.문자열.리트코드.큐로스택구현225;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        } else {
            queue1.add(x);
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}