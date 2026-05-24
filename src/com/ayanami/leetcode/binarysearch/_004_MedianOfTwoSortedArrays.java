package com.ayanami.leetcode.binarysearch;

public class _004_MedianOfTwoSortedArrays {//堆方法也可以，但时间复杂度为O((m+n)log(m+n)).操作m+n个元素,入堆和弹出都需要沿着树高log2k上浮下沉调整排序，所以单个元素入堆+弹出耗时O(2log(m+n)),
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        //找中位数是第几个
        //若总长为奇数，k1,k2相等，若为偶数，取k1k2平均值
        int k1=(n1+n2+1)/2;
        int k2=(n1+n2+2)/2;
        return((getKth(nums1,0,n1-1,nums2,0,n2-1,k1)+getKth(nums1,0,n1-1,nums2,0,n2-1,k2))*0.5);
    }

    //递归函数：在两个数组指定区间内，查找第k小的数
    private int getKth(int[]nums1,int start1,int end1,int[]nums2,int start2,int end2,int k){
        //1.计算当前数组剩余几个数
        int rm1=end1-start1+1;
        int rm2=end2-start2+1;

        //2.调整顺序，始终让nums1为更短的数据组.这样后面只需要一直判断rm1是否等于0即可
        if(rm2<rm1){
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        }

        //3.如果短数组没有剩余元素，直接从长数组里面取第K个（此时的k是新传进来扣除了之前删除元素的新k）
        if(rm1==0){
            return nums2[start2+k-1];//出迭代
        }
        //如果此时k为1，直接比较第一个数，返回较小
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        //如果k大于1,，先分别取k/2数，再比较末尾值，删掉末尾值较小的那一段
        int cut1=Math.min(rm1,k/2);//防止k/2大于rm
        int cut2=Math.min(rm2,k/2);
        int idx1=start1+cut1-1;
        int idx2=start2+cut2-1;
        if(nums1[idx1]>nums2[idx2]){
            //此时nums2前cut2个元素不可能是第k小，直接舍弃
            //k减去舍弃个数，更新区间，在新的区间中查找
            return getKth(nums1,start1,end1,nums2,idx2+1,end2,k-cut2);
        }else{
            return getKth(nums1,idx1+1,end1,nums2,start2,end2,k-cut1);
        }
/**这里一次只删去一个k/2是防止这种情况，完全不能删nums2的前k/2个元素
 nums1 = [0,1,2,3,4]
 nums2 = [5,6,7,8,9,10,11]
 k = 6（要找第6小）
 k/2 = 3 */




    }
}
