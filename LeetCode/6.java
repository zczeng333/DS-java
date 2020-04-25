class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }
        char[] str = s.toCharArray();
        ArrayList<ArrayList<Character>> record = new ArrayList<ArrayList<Character>>();//record每个元素记录Z字后每一行的元素
        ArrayList<Character> temp;
        int i, j = 0, judge = 0;//判断从上往下(0)/从下往上(1)
        for (i = 0; i < numRows; i++) {//初始化record
            record.add(new ArrayList<Character>());
        }
        for (i = 0; i < str.length; i++) {
            record.get(j).add(str[i]);
            if (judge == 0) {
                j++;
                if (j == numRows) {//从上至下遍历完
                    j = Math.max(0, numRows - 2);//下一个Z字元素位置
                    judge = 1 - judge;
                }
            } else {
                j--;
                if (j == -1) {//从下至上遍历完
                    j = Math.min(1, numRows - 1);//下一个Z字元素位置
                    judge = 1 - judge;
                }
            }
        }
        j = 0;
        for (i = 0; i < numRows; i++) {
            temp = record.get(i);
            for (int k = 0; k < temp.size(); k++) {
                str[j] = temp.get(k);
                j++;
            }
        }
        return String.valueOf(str);
    }
}