class Solution {
    private Node root;

    public List<List<Integer>> palindromePairs(String[] words) {
        this.root = new Node();//root相当于空字符""
        List<List<Integer>> result = new ArrayList<>();
        Node temp;
        char c_temp;
        int i, j, k;
        String s;
        for (i = 0; i < words.length; i++) {//构造surffix
            s = new StringBuilder(words[i]).reverse().toString();//将words[i]反转
            temp = root;
            if (judge(s)) {
                root.surffix.add(i);//""+word[i]是回文
            }
            for (j = 0; j < s.length(); j++) {
                c_temp = s.charAt(j);
                if (temp.children[c_temp - 'a'] == null) {
                    temp.children[c_temp - 'a'] = new Node();
                }
                temp = temp.children[c_temp - 'a'];
                if (judge(s.substring(j + 1))) {//word[i]-temp是回文
                    temp.surffix.add(i);
                }
            }
            temp.prefix.add(i);
        }
        for (i = 0; i < words.length; i++) {
            temp = root;
            s = words[i];
            for (j = 0; j < s.length(); j++) {
                if (judge(s.substring(j))) {
                    for (k = 0; k < temp.prefix.size(); k++) {
                        if (temp.prefix.get(k) != i) {
                            result.add(Arrays.asList(i, temp.prefix.get(k)));
                        }
                    }
                }
                c_temp = s.charAt(j);
                if (temp.children[c_temp - 'a'] == null) {
                    break;
                }
                temp = temp.children[c_temp - 'a'];
            }
            if (j == s.length()) {//这里很重要，一定要判断j遍历到了s.length()，这样才能将prefix中的word连接到s上形成回文
                for (k = 0; k < temp.surffix.size(); k++) {
                    if (temp.surffix.get(k) != i) {
                        result.add(Arrays.asList(i, temp.surffix.get(k)));
                    }
                }
            }
        }
        return result;
    }

    public boolean judge(String s) {//判断字符串是否是回文
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


class Node {
    //假设x为当前节点对应的字符串
    public List<Integer> prefix;//记录所有y.length()<x.length()，且满足x-y是回文
    public List<Integer> surffix;//记录所有y.length()>=x.length()，且满足y-x是回文
    public Node[] children;

    public Node() {
        this.children = new Node[26];
        this.prefix = new ArrayList<>();
        this.surffix = new ArrayList<>();
    }
}