class Solution {
    int n = 0;
    int i = 0;
    int j = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {//偶数长度，返回len/2与len/2+1的均值
            return (find(nums1, nums2, len / 2) + find(nums1, nums2, len / 2 + 1)) / 2;
        } else {//奇数长度，返回len/2+1
            return find(nums1, nums2, len / 2 + 1);
        }
    }

    public float find(int[] nums1, int[] nums2, int ind) {//寻找nums1和nums2联合数组的第ind个元素
        float mid = 0;
        while (n < ind && i < nums1.length && j < nums2.length) {//从前往后寻找中位数
            if (nums1[i] < nums2[j]) {
                mid = nums1[i];
                i++;
            } else {
                mid = nums2[j];
                j++;
            }
            n++;
        }
        if (i == nums1.length) {//nums1被遍历完的情况
            while (n < ind) {
                mid = nums2[j];
                j++;
                n++;
            }
        } else if (j == nums2.length) {//nums2被遍历完的情况
            while (n < ind) {
                mid = nums1[i];
                i++;
                n++;
            }
        }
        return mid;
    }
}