class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    int min = Integer.MAX_VALUE;

    public MinStack() {
        
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        min = Math.min(min, val);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        
        int val = stack.pop();
        int minVal = minStack.pop();

         min = stack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();

        return;
    }
    
    public int top() {
        
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public int getMin() {
        
        return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
}
