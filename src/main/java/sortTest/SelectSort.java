package sortTest;

/**
 * 选择排序算法
 *
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 时间复杂度：
 * 平均情况：O（n^2）
 * 最坏情况：O（n^2）
 * 最好情况：O（n^2）
 *
 * 空间复杂度：O（1）
 *
 */
public class SelectSort {
    public static void selectSort(int[] numbers){
        int size = numbers.length;
        // 每一次都把一个最小的放在首位
        for (int i = 0; i < size; i++) {
            int k = i;// 假设的最小值的位置
            for (int j = size-1; j > i; j--) {
                if(numbers[j] < numbers[k])
                    k = j;
            }
            swap(numbers,i,k);
        }
    }

    // 调换两个元素的位置
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10,20,15,0,6,7,2,1,-5,55};
        SelectSort.selectSort(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
