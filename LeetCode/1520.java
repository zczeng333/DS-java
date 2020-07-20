class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[][] pos = new int[26][3];
        int temp;
        for (int i = 0; i < s.length(); i++) {//pos[i][0],pos[i][1]分别记录字符i的起止位置,pos[i][2]记录字符是否出现过
            temp = (int) (s.charAt(i) - 'a');
            if (pos[temp][2] == 0) {
                pos[temp][0] = i;
                pos[temp][1] = i;
            }//没有记录过起止位置
            else {
                pos[temp][1] = i;
            }//更新终止位置
            pos[temp][2] = -1;
        }
        for (int i = 0; i < 26; i++) {////pos[i][0],pos[i][1]分别记录字符i扩张的字符串起止位置
            int left = pos[i][0], right = pos[i][1];
            if (pos[i][2] == -1) {//该字符出现过
                for (int j = left + 1; j < right; j++) {
                    if (left > pos[(int) (s.charAt(j) - 'a')][0]) {//非常tricky，在扩张了left之后，遍历的字符范围也要相应扩张（通过重置j为left）
                        left = pos[(int) (s.charAt(j) - 'a')][0];
                        j = pos[(int) (s.charAt(j) - 'a')][0];
                    }
                    right = Math.max(right, pos[(int) (s.charAt(j) - 'a')][1]);
                }
            }
            pos[i][0] = left;
            pos[i][1] = right;
        }
        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[1] - o1[0] - o2[1] + o2[0];//右边相同时按照长度排序
                return o1[1] - o2[1];//按照右边界排序
            }
        });
        List<String> answer = new LinkedList<String>();
        temp = -1;
        for (int i = 0; i < 26; i++) {
            if (pos[i][2] == -1 && temp < pos[i][0]) {
                temp = pos[i][1];
                answer.add(s.substring(pos[i][0], pos[i][1] + 1));
            }
        }
        return answer;
    }
}