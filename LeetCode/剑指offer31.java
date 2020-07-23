class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int n = pushed.length, i = 0, j = 0, flag = 1;
        Stack<Integer> s = new Stack<Integer>();
        while (i < n) {
            flag = 0;
            while (j < n && pushed[j] != popped[i]) {//入栈
                flag = 1;
                s.push(pushed[j]);
                j++;
            }
            if (j == n) {
                break;
            }//入栈已经遍历到底，但仍未匹配出栈
            if (pushed[j] == popped[i]) {
                j++;//入栈
                i++;//出栈
                flag = 1;
            }
            while (s.size() > 0 && s.peek() == popped[i]) {//出栈
                flag = 1;
                s.pop();
                i++;
            }
            if (flag == 0) {
                break;
            }//既未入栈，也未出栈
        }
        if (i == n) {
            return true;
        }
        return false;
    }
}