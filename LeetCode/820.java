class Solution {
    public int minimumLengthEncoding(String[] words) {//相当于一个在words中找共同结束的子串的问题
        if (words.length == 0) {
            return 0;
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });//先按长度从长至短排序
        ArrayList<String> record = new ArrayList<String>();
        int i, j, sum = 0;
        String temp;
        record.add(words[0]);
        for (i = 1; i < words.length; i++) {//循环检查是否是长字符串的共尾子串
            for (j = 0; j < record.size(); j++) {
                temp = (String) record.get(j);
                if (temp.substring(temp.length() - words[i].length(), temp.length()).equals(words[i])) {//有公用子串
                    break;
                }
            }
            if (j == record.size()) {
                record.add(words[i]);
            }
        }
        for (i = 0; i < record.size(); i++) {
            sum = sum + record.get(i).length() + 1;
        }
        return sum;
    }

    public boolean compare(String a, String b) {//a是长字符串，b是短字符串
        int i = a.length() - 1, j = b.length() - 1;
        while (j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}