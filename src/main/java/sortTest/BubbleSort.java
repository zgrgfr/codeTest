package sortTest;

/**
* 冒泡排序
 *
* 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
* 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
* 针对所有的元素重复以上的步骤，除了最后一个。
* 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
*
 * 时间复杂度：
 * 平均情况：O（n^2）
 * 最坏情况：O（n^2）
 * 最好情况：O（n）
 *
 * 空间复杂度：O（1）
 *
*/
public class BubbleSort {
    public static void bubbleSort(int[] numbers,int start,int end){
        if(numbers == null || numbers.length == 0 || numbers.length == 1)
            return ;
        if(start < end){
            for(int i=start; i+1<=end ;i++){
                if(numbers[i] > numbers[i+1]){
                    swap(numbers,i,i+1);
                }
            }
            bubbleSort(numbers,start,end-1);
        }
    }

    /**
     * 调换两个元素的位置
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,6,4,7,8,1};
        BubbleSort.bubbleSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
