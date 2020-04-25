class Solution {
    public int majorityElement(int[] nums) {
    	HashMap<Integer,Integer> map=new HashMap<>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			map.put(nums[i],map.get(nums[i])+1);
    			if(map.get(nums[i])>Math.floor(nums.length/2)){return nums[i];}
    		}
    		else{
    			map.put(nums[i],1);
                if(map.get(nums[i])>Math.floor(nums.length/2)){return nums[i];}
    		}
    	}
    	return -1;
    }
}

//Solution2: 排序后返回中间元素...很强
class Solution {
    public int majorityElement(int[] nums) {
    	Arrays.sort(nums);
    	return nums[(int)nums.length/2];
    }
}