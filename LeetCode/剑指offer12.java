//Solution 1:使用hashmap分别记录不同字符的位置，之后递归遍历（想得太复杂了）
class Solution {
    public HashMap<Character, Integer> num;//记录word中不同字符出现次数
    public HashMap<Character, LinkedList> pos;//记录board中对应字符的位置

    public boolean exist(char[][] board, String word) {
        num = new HashMap<Character, Integer>();
        pos = new HashMap<Character, LinkedList>();
        char temp;
        LinkedList<int[]> templist;
        for (int i = 0; i < word.length(); i++) {//构建num
            temp = word.charAt(i);
            if (num.containsKey(temp)) {
                num.put(temp, num.get(temp) + 1);
            } else {
                num.put(temp, 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                temp = board[i][j];
                if (num.containsKey(temp)) {
                    if (pos.containsKey(temp)) {//之前已经记录过该字符
                        templist = pos.get(temp);
                        templist.add(new int[]{i, j});
                    } else {//之前没有记录过该字符
                        templist = new LinkedList<int[]>();
                        templist.add(new int[]{i, j});
                        pos.put(temp, templist);
                    }
                }
            }
        }
        // printvalue();
        for (char key : num.keySet()) {
            if (!pos.containsKey(key) || num.get(key) > pos.get(key).size()) {
                return false;
            }//board中的字符数不满足word要求
        }
        temp = word.charAt(0);
        templist = pos.get(temp);
        for (int i = 0; i < templist.size(); i++) {
            int[] p = new int[]{templist.get(i)[0], templist.get(i)[1]};
            // System.out.println(Arrays.toString(p));
            templist.remove(i);
            if (check(word.substring(1), p)) {
                return true;
            }
            templist.add(i, p);
            // for(int j=0;j<templist.size();j++){
            //     System.out.printf("[%d,%d] ",templist.get(j)[0], templist.get(j)[1]);
            // }
            // System.out.println();
        }
        return false;
    }

    public boolean check(String word, int[] p1) {//对word和board进行判别,p表示上一个字符的位置
        if (word.length() == 0) {
            return true;
        }
        char temp = word.charAt(0);
        LinkedList<int[]> templist = pos.get(temp);
        for (int i = 0; i < templist.size(); i++) {
            int[] p2 = new int[]{templist.get(i)[0], templist.get(i)[1]};
            if (Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) == 1) {//字符相邻，继续迭代
                System.out.println(Arrays.toString(p2));
                templist.remove(i);
                if (check(word.substring(1), p2)) {
                    return true;
                }
                templist.add(i, p2);
            }
        }
        return false;
    }

    public void printvalue() {
        System.out.println("num");
        for (char key : num.keySet()) {
            System.out.printf("%c:%d" + "\n", key, num.get(key));
        }

        LinkedList<int[]> temp;
        System.out.println("pos");
        for (char key : pos.keySet()) {
            System.out.printf(key + ": ");
            temp = pos.get(key);
            for (int j = 0; j < temp.size(); j++) {
                System.out.printf("[%d,%d] ", temp.get(j)[0], temp.get(j)[1]);
            }
            System.out.println();
        }
    }
}

//Solution 2: DFS
class Solution {
    public int[][] record;

    public boolean exist(char[][] board, String word) {
        record = new int[board.length][board[0].length];//record记录位置是否被遍历过
        if (word.length() == 0) {
            return true;
        }
        char temp = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == temp) {
                    record[i][j] = -1;
                    if (check(word.substring(1), new int[]{i, j}, board)) {
                        return true;
                    }
                    record[i][j] = 0;
                }
            }
        }
        return false;
    }

    public boolean check(String word, int[] p, char[][] board) {
        if (word.length() == 0) {
            return true;
        }
        char temp = word.charAt(0);
        record[p[0]][p[1]] = -1;
        if (p[0] > 0 && record[p[0] - 1][p[1]] == 0 && board[p[0] - 1][p[1]] == temp && check(word.substring(1), new int[]{p[0] - 1, p[1]}, board)) {
            return true;
        }//上
        if (p[0] < board.length - 1 && record[p[0] + 1][p[1]] == 0 && board[p[0] + 1][p[1]] == temp && check(word.substring(1), new int[]{p[0] + 1, p[1]}, board)) {
            return true;
        }//下
        if (p[1] > 0 && record[p[0]][p[1] - 1] == 0 && board[p[0]][p[1] - 1] == temp && check(word.substring(1), new int[]{p[0], p[1] - 1}, board)) {
            return true;
        }//左
        if (p[1] < board[0].length - 1 && record[p[0]][p[1] + 1] == 0 && board[p[0]][p[1] + 1] == temp && check(word.substring(1), new int[]{p[0], p[1] + 1}, board)) {
            return true;
        }//右
        record[p[0]][p[1]] = 0;
        return false;
    }
}