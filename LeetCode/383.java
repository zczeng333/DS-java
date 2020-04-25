class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] S1 = new int[26];
        int[] S2 = new int[26];
        char[] R = ransomNote.toCharArray();
        char[] M = magazine.toCharArray();
        int i;
        for (i = 0; i < R.length; i++) {
            S1[R[i] - 'a'] = S1[R[i] - 'a'] + 1;
        }
        for (i = 0; i < M.length; i++) {
            S2[M[i] - 'a'] = S2[M[i] - 'a'] + 1;
        }
        for (i = 0; i < 26; i++) {
            if (S1[i] > S2[i]) {
                return false;
            }
        }
        return true;
    }
}