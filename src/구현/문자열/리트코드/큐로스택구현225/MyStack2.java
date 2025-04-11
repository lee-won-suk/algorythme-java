package 구현.문자열.리트코드.큐로스택구현225;

import java.util.ArrayDeque;

class MyStack2 {

    private ArrayDeque<Integer> queue;

    public MyStack2() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        //1. 맨앞에 넣는다.
        queue.addFirst(x);
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}