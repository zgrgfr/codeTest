package sortTest;

/**
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 *
 *
 * 时间复杂度：
 * 平均情况：O（nlog2n）
 * 最坏情况：O（nlog2n）
 * 最好情况：O（nlog2n）
 *
 * 空间复杂度：O（1）
 *
 * Created by guofengrui on 2017/7/6.
 */
public class MergeSort {

    public static void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }


    public static void mergeSort(int[] nums, int low, int high){
        int mid = (low+high)/2;
        if(low < high){
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    /**
     * 合并两个排序过的数组
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] array,int low, int mid, int high){
        int[] nums = new int[high-low+1];
        int i = low; // 左指针
        int j = mid+1; // 右指针
        int k = 0; // 新数组的指针

        // 合并两个数组重叠的部分
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                nums[k++] = array[i++];
            }else{
                nums[k++] = array[j++];
            }
        }

        // 若左边的数组还有数据则合并进新数组
        while(i <= mid){
            nums[k++] = array[i++];
        }

        // 若右边的数组还有数据则合并进新数组
        while(j <= high){
            nums[k++] = array[j++];
        }

        // 合并进原数组
        for (int l = 0; l < nums.length; l++) {
            array[low+l] = nums[l];
        }
    }

    public static void main(String[] args) {
        int[] array = {10,20,15,0,6,7,2,1,-5,55};
        MergeSort.mergeSort(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }


}
