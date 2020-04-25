class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        ArrayList p = new ArrayList();
        ArrayList hashv = new ArrayList();
        ArrayList f = new ArrayList();
        char c_temp;
        String s_temp;
        int temp = 0;
        int count = 0;
        int i, j, judge;
        paragraph = paragraph.toLowerCase();
        for (i = 0; i < paragraph.length(); i++) {
            c_temp = paragraph.charAt(i);
            if (c_temp < 'a' || c_temp > 'z') {
                p.add(paragraph.substring(temp, i));
                while (i < paragraph.length() && (paragraph.charAt(i) < 'a' || paragraph.charAt(i) > 'z')) {
                    i = i + 1;// find the start of the next word
                }
                temp = i;
            }
        }
        if (paragraph.charAt(paragraph.length() - 1) >= 'a' && paragraph.charAt(paragraph.length() - 1) <= 'z') {//add last string
            p.add(paragraph.substring(temp, i));
        }
        for (i = 0; i < p.size(); i++) {
            s_temp = (String) p.get(i);
            judge = 0;
            for (j = 0; j < banned.length; j++) {
                if (s_temp.equals(banned[j])) {
                    judge = 1;
                    break;
                }
            }
            if (judge == 1) {// in banned list
                continue;
            }
            for (j = 0; j < hashv.size(); j++) {
                if ((int) hashv.get(j) == s_temp.hashCode()) {
                    f.set(j, (int) f.get(j) + 1);
                    break;
                }
            }
            if (j == hashv.size()) {
                hashv.add(s_temp.hashCode());
                f.add(1);
            }
        }
        int max_hash = 0;
        temp = 0;
        for (i = 0; i < hashv.size(); i++) {
            if ((int) f.get(i) > temp) {
                max_hash = (int) hashv.get(i);
                temp = (int) f.get(i);
            }
        }
        for (i = 0; i < p.size(); i++) {
            if (p.get(i).hashCode() == max_hash) {
                return (String) p.get(i);
            }
        }
        return null;
    }
}