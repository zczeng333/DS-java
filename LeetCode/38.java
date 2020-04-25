class Solution {
    public String countAndSay(int n) {
        ArrayList record = new ArrayList();
        String s = "";
        int i;
        record.add(1);
        ArrayList pre = record;
        for (i = 1; i < n; i++) {
            record = next(pre);
            // System.out.println(record);
        }
        for (i = 0; i < record.size(); i++) {
            s = s + record.get(i).toString();
        }
        return s;
    }

    public ArrayList next(ArrayList pre) {
        ArrayList coef = new ArrayList();    //record coefficient
        ArrayList value = new ArrayList();    //record value
        ArrayList record = new ArrayList();
        int i, temp, count;
        for (i = 0; i < pre.size(); i++) {
            temp = (int) pre.get(i);
            value.add(temp);
            count = 1;
            while (i < pre.size() - 1 && temp == (int) pre.get(i + 1)) {
                count = count + 1;
                i = i + 1;
            }
            coef.add(count);
            System.out.println(count);
            System.out.println(temp);
            System.out.println();
        }
        for (i = 0; i < coef.size(); i++) {
            record.add((int) coef.get(i));
            record.add((int) value.get(i));
        }
        return record;
    }
}