class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> record=new ArrayList<String>();
        if(digits.length()==0){return record;}
    	String[] dict=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	int i, len=digits.length();
    	int[] convert=new int[len];
    	for(i=0;i<len;i++){
    		convert[i]=(int)(digits.charAt(i)-'2');//转化为数字，并进行2的偏移
    	}
    	int[] p=new int[len];//记录digits[i]对应遍历的元素
    	char[] temp=new char[len];
    	while(p[0]!=dict[convert[0]].length()){//p[0]没有遍历完
    		for(i=0;i<len;i++){
    			temp[i]=dict[convert[i]].charAt(p[i]);
    		}
    		record.add(String.valueOf(temp));
    		i=len-1;
    		while(i>=0){//逐一向前增加p[i]的指针值
    			p[i]++;
    			if(i!=0&&p[i]==dict[convert[i]].length()){//遍历到了p[i]的终点
    				p[i]=0;
    				i--;
    			}
    			else{break;}
    		}
    	}
    	return record;
    }
}