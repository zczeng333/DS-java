class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int i = nums.length - 2, tempv, j, k, size;
        List<Integer> temp;
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        while (i >= 0) {//交换ans中所有arraylist的第i个元素与[i+1,len-1]内的元素
            size = ans.size();
            for (j = 0; j < size; j++) {
                for (k = i + 1; k < nums.length; k++) {
                    temp = new ArrayList<Integer>(ans.get(j));//克隆arraylist(j)
                    tempv = temp.get(i);
                    temp.set(i, temp.get(k));//将i值更改为k的值
                    temp.set(k, tempv);//将k值更改为i的值
                    ans.add(temp);
                }
            }
            i--;
        }
        return ans;
    }
}