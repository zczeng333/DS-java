class Solution {
    public String frequencySort(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[][] record = new int[128][2];    //each row represents a character
        char[] s_new = new char[s.length()];
        int i, j, count;
        char ele;
        for (i = 0; i < 128; i++) {    //index for each character
            record[i][0] = i;
        }
        for (i = 0; i < s.length(); i++) {    //count frequency for each character
            ele = s.charAt(i);
            record[(int) (ele)][1] = record[(int) (ele)][1] + 1;
        }
        record = merge_sort(record);
        count = 0;
        for (i = 0; i < 128; i++) {
            if (record[i][1] == 0) {
                break;
            }
            ele = (char) (record[i][0]);
            for (j = 0; j < record[i][1]; j++) {
                s_new[count] = ele;
                count = count + 1;
            }
        }
        return new String(s_new);
    }

    public int[][] merge_sort(int[][] args) {
        if (args.length == 1) {    //only 1 element left, return
            return args;
        }
        int i, j, k;
        int mid = (int) args.length / 2;
        int[][] result = new int[args.length][2];
        int[][] left = new int[mid][2];
        int[][] right = new int[args.length - mid][2];
        for (i = 0; i < mid; i++) {
            left[i] = args[i];
        }
        for (j = 0; j < args.length - mid; j++) {
            right[j] = args[j + mid];
        }
        left = merge_sort(left);    //left subsequence after sorting
        right = merge_sort(right);    //right subsequence after sorting
        i = j = k = 0;
        while (i < args.length) {
            if (j == left.length) {    //left sequence already sorted
                result[i] = right[k];
                k += 1;
            } else if (k == right.length) {    //right sequence already sorted
                result[i] = left[j];
                j += 1;
            } else if (left[j][1] > right[k][1]) {    //compare the smallest element of left & right,and pick the smaller one
                result[i] = left[j];
                j += 1;
            } else {
                result[i] = right[k];
                k += 1;
            }
            i = i + 1;
        }
        return result;
    }
}