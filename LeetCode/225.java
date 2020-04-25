class MyStack {
    public LinkedList s;
    /** Initialize your data structure here. */
    public MyStack() {
        this.s=new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        s.add(x);//新数据加入栈底
        for(int i=0;i<s.size()-1;i++){//将原来栈中数据反转
            s.add(s.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int)s.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return (int)s.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return s.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */