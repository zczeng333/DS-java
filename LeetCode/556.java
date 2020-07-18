class Solution {
    public int nextGreaterElement(int n) {
        if (n >= Math.pow(2, 31)) {
            return -1;
        }
        char[] record = String.valueOf(n).toCharArray();  //convert to String type
        int i, index;
        int len = record.length;
        char max = record[len - 1];
        char min, temp;
        for (i = len - 2; i >= 0; i--) {
            if (record[i] >= max) {
                max = record[i];
            } else {
                break;
            }// record[i:i.length] needs to be adjust
        }
        if (i < 0) {
            return -1;
        } // no such integer exists
        index = i;// record[index] needs to be replaced
        i = i + 1;
        min = record[i];
        while (i < len) {
            if (record[i] > record[index]) {
                min = record[i];
                i = i + 1;
            } else {
                i = i - 1;
                break;
            }
        }// record[i] is the min value applicable
        if (i == len) {
            record[len - 1] = record[index];
            record[index] = min;
        } else {// replace
            record[i] = record[index];
            record[index] = min;
            while (true) {// record[index+1:len] is in descending order
                if (record[i] > record[i - 1] && i > index + 1) {
                    temp = record[i];
                    record[i] = record[i - 1];
                    record[i - 1] = temp;
                    i = i - 1;
                } else if (record[i] < record[i + 1] && i < len - 1) {
                    temp = record[i];
                    record[i] = record[i + 1];
                    record[i + 1] = temp;
                    i = i + 1;
                } else {
                    break;
                }
            }
        }
        i = index + 1;
        while (i < index + len - i) {
            temp = record[i];
            record[i] = record[index + len - i];
            record[index + len - i] = temp;
            i = i + 1;
        }
        try {
            return Integer.parseInt(String.valueOf(record));
        } catch (Exception e) {
            return -1;
        }
    }
}