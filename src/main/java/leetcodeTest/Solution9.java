package leetcodeTest;

/**
 * 给定整数数组， 除了一个元素之外，每个元素都会出现两次。找到那个单一的。
 * Created by guofengrui on 2017/6/9.
 */
public class Solution9 {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int result = 0;
        for(int c : A){
            result ^= c;
        }
        return result;
    }
}
