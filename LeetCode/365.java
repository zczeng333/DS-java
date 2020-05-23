//图的DFS，超时
class Solution {
    public HashMap<int[], Integer> map = new HashMap<int[], Integer>();
    public int cx, cy, target;//两个杯子的大小

    public boolean canMeasureWater(int x, int y, int z) {
        cx = x;
        cy = y;
        taregt = z
        return Remainwater(0, 0);//起始状态两个杯子均含有0的水量
    }

    public boolean RemainWater(int rx, int ry) {
        if (rx == target || ry == target || rx + ry == target) {
            return true;
        }
        if (map.containsKey(new int[]{rx, ry})) {
            return false;
        }//该状态已经遍历过
        map.put(new int[]{rx, ry}, rx + ry);//将状态放入其中
        if (RemainWater(cx, ry)) {
            return true;
        }//将x灌满
        if (RemainWater(rx, cy)) {
            return true;
        }//将y灌满
        if (RemainWater(min(rx + ry, cx), max(0, rx + ry - cx)) {
            return true;
        }//将y倒入x
        if (Remainwater(max(0, rx + ry - cy), min(rx + ry, cy)) {
            return true;
        }//将x倒入y
        if (RemainWater(0, ry)) {
            return true;
        }//清空x
        if (RemainWater(rx, 0)) {
            return true;
        }//清空y
        return false;
    }
}

//转化为最大公约数问题
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (x + y < z) return false;
        int big = Math.max(x, y);
        int small = x + y - big;
        if (small == 0) return big == z;
        while (big % small != 0) {
            int temp = small;
            small = big % small;
            big = temp;
        }
        return z % small == 0;
    }
}