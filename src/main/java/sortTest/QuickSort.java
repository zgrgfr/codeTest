package sortTest;

/**
 *快速排序
 *
 * 把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；
 * 交换了以后再和小的那端比，比它小不交换，比他大交换。这样循环往复，一趟排序完成，左边就是比中轴小的，
 * 右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
 *
 * 时间复杂度：
 * 平均情况：O（nlog2n）
 * 最坏情况：O（n^2）
 * 最好情况：O（nlog2n）
 *
 * 空间复杂度：O（nlog2n）
 * Created by guofengrui on 2017/7/6.
 */
public class QuickSort {

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low   开始位置
     * @param high  结束位置
     * @return  中轴所在位置
     */
    private static int getMiddle(int[] numbers, int low,int high){
        // 取第一个为中轴
        int temp = numbers[low];
        while(low < high){
            while(low <high && numbers[high] > temp){
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] < temp){
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;
        return low;
    }
    /**
     *
     * @param numbers 待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    private static void quickSort(int[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high);
            quickSort(numbers,low,middle);
            quickSort(numbers,middle+1,high);
        }
    }

    /**
     * 快速排序
     * @param numbers 排序数组
     */
    public static void quick(int[] numbers){
        if(numbers == null || numbers.length == 0){
            return;
        }
        quickSort(numbers,0,numbers.length-1);
    }

    public static void main(String[] args) {
        int[] array = {10,20,15,0,6,7,2,1,-5,55};
        QuickSort.quick(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
