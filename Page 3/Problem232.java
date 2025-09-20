import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class Problem232 {

}

class Implement_Queue_using_Stacks {
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<Integer>();
            this.stack2 = new Stack<Integer>();
        }

        // Push element x to the back of queue.
        public void push(int x) {
            stack1.push(x);
        }

        // Removes the element from in front of queue.
        public int pop() {
            if (!stack2.isEmpty()) {
                return stack2.pop(); // stack is queue-order, queue-head at this-stack-top
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }

        // Get the front element.
        public int peek() {
            int ret = 0;
            if (!stack2.isEmpty()) {
                ret = stack2.peek();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                ret = stack2.peek();
            }

            return ret;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}

class MyQueue {
    private Deque<Integer> stk1 = new ArrayDeque<>();
    private Deque<Integer> stk2 = new ArrayDeque<>();

    public MyQueue() {
    }

    public void push(int x) {
        stk1.push(x);
    }

    public int pop() {
        move();
        return stk2.pop();
    }

    public int peek() {
        move();
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }

    private void move() {
        while (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
    }
}