class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        //该问题其实就是求解最大公约数
        if (deck.length <= 1) {
            return false;
        }
        int[] hash = new int[10000];
        int i, temp;//temp记录hash[i]的最大公约数
        for (i = 0; i < deck.length; i++) {
            hash[deck[i]]++;
        }
        Arrays.sort(hash);
        temp = hash[hash.length - 1];
        i = hash.length - 2;
        while (hash[i] != 0) {
            temp = MaxCommon(temp, hash[i]);
            if (temp < 2) {
                return false;
            }
            i--;
        }
        return temp >= 2;
    }

    public int MaxCommon(int a, int b) {//求解整数a与b之间的最大公约数
        if (a < b) {//a放大数
            int temp = b;
            b = a;
            a = temp;
        }
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}

class c implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        }
        if (o1 < o2) {
            return 1;
        }
        return 0;
    }
}