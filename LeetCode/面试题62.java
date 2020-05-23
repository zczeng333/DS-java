class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        int i;
        for (i = 0; i < n; i++) {
            record.add(i);
        }
        i = m - 1;
        while (record.size() > 1) {
            i = i % record.size();
            while (record.size() > 1 && i < record.size()) {
                record.remove(i);
                i = i + m - 1;
            }
        }
        return record.get(0);
    }
}