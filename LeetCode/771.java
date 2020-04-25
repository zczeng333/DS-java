class Solution {
    public int numJewelsInStones(String J, String S) {
        int[][] record = new int[52][2];
        int count = 0;
        int i;
        char temp;
        for (i = 0; i < J.length(); i++) {
            temp = J.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                record[(int) (temp - 'A')][0] = 1;
            }
            if (temp >= 'a' && temp <= 'z') {
                record[(int) (temp - 'a') + 26][0] = 1;
            }
        }
        for (i = 0; i < S.length(); i++) {
            temp = S.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                record[(int) (temp - 'A')][1] = record[(int) (temp - 'A')][1] + 1;
            }
            if (temp >= 'a' && temp <= 'z') {
                record[(int) (temp - 'a') + 26][1] = record[(int) (temp - 'a') + 26][1] + 1;
            }
        }
        for (i = 0; i < 52; i++) {
            if (record[i][0] == 1) {
                count = count + record[i][1];
            }
        }
        return count;
    }
}