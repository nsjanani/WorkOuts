package com.sample.workout1;

import java.util.Stack;

public class SpecialStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> supportingStack = new Stack<>();

    public void push(int value) {
        if(stack.isEmpty()) {
            stack.push(value);
            supportingStack.push(value);
        } else {
            stack.push(value);
            if (stack.peek() <= supportingStack.peek()) {
                supportingStack.push(value);
            }
        }
    }

    public void pop() {
        if(stack.peek().equals(supportingStack.peek())) {
            supportingStack.pop();
        }
        stack.pop();
    }

    public int getMin() {
        return supportingStack.peek();
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();
        stack.push(50);
        stack.push(40);
        stack.push(35);
        System.out.println("The current minimum element is " + stack.getMin());
        stack.push(55);
        stack.push(37);
        stack.push(20);
        System.out.println("The current minimum element is " + stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println("The current minimum element is " + stack.getMin());
        stack.push(60);
        stack.pop();
        stack.push(10);
    }

}
