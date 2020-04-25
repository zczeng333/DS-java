class Solution {
	public String reverseStr(String s, int k) {
		char[] str = s.toCharArray();
		char temp;
		int start = 0;
		int i, end;
		while (start < str.length) {
			end = Math.min(start + k, str.length);
			for (i = start; i < start + end - 1 - i; i++) {
				temp = str[i];
				str[i] = str[start + end - 1 - i];
				str[start + end - 1 - i] = temp;
			}
			start = end + k;
		}
		return String.valueOf(str);
	}
}