class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //判断一个矩阵的四个角中是否存在一个角在另一个矩阵内
        //(x11,y11)rec1左下,(x12,y12)rec1右上,(x21,y21)rec2左下,(x22,y22)rec2右上
        if (rec1[1] >= rec2[3] || rec2[1] >= rec1[3]) {
            return false;
        }//两个矩形的上下边不可能相交
        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2]) {
            return false;
        }//两个矩形的左右边不可能相交
        return true;
    }
}