class Solution {
    HashMap<Character, Integer> hash_s = new HashMap<Character, Integer>();//s字符串的hashmap
    HashMap<Character, Integer> hash_t = new HashMap<Character, Integer>();//t字符串的hashmap

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int left = 0, right = 0, record_l, record_r;//左右指针，记录目前最短子串的左右位置
        for (int i = 0; i < t.length(); i++) {//构造t字符串的hashmap
            if (hash_t.containsKey(t.charAt(i))) {
                hash_t.put(t.charAt(i), hash_t.get(t.charAt(i)) + 1);
            } else {
                hash_t.put(t.charAt(i), 1);
            }
        }
        while (right < s.length() && !valid()) {//找到第一个满足条件的子串right
            update_s(0, s.charAt(right));
            right++;
        }
        if (!valid()) {
            return "";
        }//不存在满足条件的子串
        record_l = left;
        record_r = right;//此时的right指向第一个满足条件的子串右边界+1，最短子串为substring(record_l,record_r);
        while (right < s.length()) {
            while (valid()) {
                update_s(1, s.charAt(left));//更新删除left位置元素后的hash_s
                left++;
            }
            //此时left是第一个不满足条件的位置，最短子串为substring(left-1,right)
            if (right - left + 1 < record_r - record_l) {
                record_l = left - 1;
                record_r = right;
            }
            while (right < s.length() && !valid()) {
                update_s(0, s.charAt(right));
                right++;
            }
        }
        if (valid()) {
            while (valid()) {
                update_s(1, s.charAt(left));//更新删除left位置元素后的hash_s
                left++;
            }
            //此时left是第一个不满足条件的位置，最短子串为substring(left-1,right)
            if (right - left + 1 < record_r - record_l) {
                record_l = left - 1;
                record_r = right;
            }
        }
        return s.substring(record_l, record_r);
    }

    public void update_s(int flag, char c) {//更新hash_s，flag=0表示增加，flag=1表示删除
        if (flag == 0) {
            if (hash_s.containsKey(c)) {
                hash_s.put(c, hash_s.get(c) + 1);
            } else {
                hash_s.put(c, 1);
            }
        } else {
            hash_s.put(c, hash_s.get(c) - 1);
        }
    }

    public boolean valid() {//比较hash_s是否覆盖所有hash_t中的值
        Iterator iter = hash_t.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (hash_s.containsKey(key) && hash_s.get(key) >= val) {
                continue;
            }
            return false;
        }
        return true;
    }
}