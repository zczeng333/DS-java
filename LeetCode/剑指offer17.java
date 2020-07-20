class Solution {
    public int[] printNumbers(int n) {
        if (n == 0) {
            return null;
        }
        int max = 0;
        while (n > 0) {
            max = 10 * max + 9;
            n--;
        }
        int[] answer = new int[max];
        for (int i = 0; i < max; i++) {
            answer[i] = i + 1;
        }
        return answer;
    }
}