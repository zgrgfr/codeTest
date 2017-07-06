package leetcodeTest;

/**
 *
     有N个孩子站在一条线上。每个孩子都被分配一个评分值。
     你给这些孩子的糖果受到以下要求：
     每个孩子必须至少有一个糖果。
     具有较高评级的儿童比邻居获得更多的糖果。
     你必须给予的最低糖果是什么？
 *
 * Created by guofengrui on 2017/6/20.
 */
public class Solution10 {
    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int len = ratings.length;
        if(len == 1)return 1;
        int[] array = new int[len];
        // 初始化数组，对应的是该位置的孩子得到的糖果数
        for(int i=0; i<array.length ; i++)
            array[i] = 1;
        // 从左到右遍历
        for(int i=1; i<len; i++){
            if(ratings[i] > ratings[i-1])
                array[i] = array[i-1] + 1;
        }
        // 从右到左遍历
        for(int i = len-2; i>=0; i--){
            if(ratings[i] > ratings[i+1] && array[i] <= array[i+1])
                array[i] = array[i+1] + 1;
        }

        int sum = 0;
        for(int i : array){
            sum += i;
        }
        return sum;
    }
}
