package LeetCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class PN155 {

}

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minVal;

    public MinStack() {
        stack = new ArrayDeque<>();
        minVal = new ArrayDeque<>();
    }

    public void push(int value) {

        stack.push(value);
        minVal.push(minVal.isEmpty() ? value : Math.min(value, minVal.peek()));
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minVal.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal.peek();
    }
}
