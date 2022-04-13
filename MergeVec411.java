/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

来源：力扣（LeetCode）88
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class MergeVec411 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m-1;//nums1的尾标
        int i = n-1;//nums2的尾标
        //倒序
        for (int k = m+n-1; k>=0;k--){
            //什么时候要nums1[j]：nums2[i]的i小于零了，或者，谁大谁就先占着，注意边界
            if(i<0 || (j>=0 && nums1[j]>=nums2[i])){
                nums1[k]=nums1[j];
                j--;
            }else{
                nums1[k]=nums2[i];
                i--;
            }
        }
        System.out.println(nums1);
    }
}