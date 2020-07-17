class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] prefix = new int[nums.length + 1];//前缀和，prefix[i]记录nums[0]~nums[i](包含收尾)的和
        int sum = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        map.put(0, new ArrayList<Integer>());
        map.get(0).add(0);
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            if (map.containsKey(prefix[i])) {
                map.get(prefix[i]).add(i);
            } else {
                map.put(prefix[i], new ArrayList<Integer>());
                map.get(prefix[i]).add(i);
            }
        }
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int v = (int) entry.getKey();
            if (map.containsKey(v + k)) {
                sum = sum + combination(map.get(v), map.get(v + k));
            }
        }
        return sum;
    }

    public int combination(ArrayList a, ArrayList b) {//计算两个链表中的可行组合(要求a在b前)
        int i = 0, j = 0, sum = 0;
        while (i < a.size() && j < b.size()) {
            while (j < b.size() && (int) b.get(j) <= (int) a.get(i)) {
                j++;
            }
            sum = sum + b.size() - j;
            i++;
        }
        return sum;
    }
}