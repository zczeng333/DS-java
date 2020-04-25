public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int j;
        for (int i = 1; i < strs.length; i++) {
            pre = pre.substring(0, Math.min(pre.length(), strs[i].length()));
            for (j = 0; j < pre.length(); j++) {
                if (strs[i].charAt(j) != pre.charAt(j)) {
                    if (j == 0) {
                        pre = "";
                    } else {
                        pre = pre.substring(0, j);
                    }
                    break;
                }
            }
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }
}