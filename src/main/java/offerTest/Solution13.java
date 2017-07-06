package offerTest;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * Created by guofengrui on 2017/6/1.
 */
public class Solution13 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size > num.length){
            return list;
        }
        int[] array = new int[size];
        // 总共有这么多个窗口
        int number = num.length - size + 1;
        for (int i = 0; i <number ; i++) {
            for (int j = 0; j <size ; j++) {
                array[j] = num[j + i];
            }
            getMax(array);
        }
        return list;
    }

    public void getMax(int[] array){
        if(array != null && array.length > 0){
            int max = array[0];
            for (int i = 0; i <array.length ; i++) {
                if(max < array[i])
                    max = array[i];
            }
            list.add(max);
        }
    }
}
