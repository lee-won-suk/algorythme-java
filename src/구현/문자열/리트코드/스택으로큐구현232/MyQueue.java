package 구현.문자열.리트코드.스택으로큐구현232;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int front =0;

    public MyQueue() {
    }
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    public int pop() {
        int a = stack1.pop();
        if(!stack1.isEmpty()) {
            front = stack1.peek();
        }
        return a;
    }

    public int peek() {
        return front;
    }
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
