package sortTest;

/**
 * 直接插入排序
 *
 * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 *
 * 时间复杂度：
 * 平均情况：O（n^2）
 * 最坏情况：O（n^2）
 * 最好情况：O（n）
 *
 * 空间复杂度：O（1）
 *
 */
public class InsertSort {
    public static void insertSort(int[] numbers){
        int size = numbers.length;
        for (int i = 1; i < size; i++) {
            if(numbers[i-1] > numbers[i]){
                // 存储该位置的状态信息
                int temp = numbers[i];
                int j = i;
                while(j > 0 && numbers[j-1] > temp){
                    numbers[j] = numbers[j-1];
                    j--;
                }
                numbers[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10,20,15,0,6,7,2,1,-5,55};
        InsertSort.insertSort(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
