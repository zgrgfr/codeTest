package Test;
import Test.ListNode;

import javax.jnlp.IntegrationService;
import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * Created by guofengrui on 2017/7/18.
 */
public class test {
    private static int getSum(int i, int j ){
        int sum = 0;
        while(i != 0){
            sum += i%j;
            i = i/j;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeA = scanner.nextInt();
        int sizeB = scanner.nextInt();
        int[] arrayA = new int[sizeA];
        int[] arrayB = new int[sizeB];
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<sizeA ;i++){
            arrayA[i] = scanner.nextInt();
            set.add(arrayA[i]);
        }
        for(int i=0; i<sizeB ;i++){
            arrayB[i] = scanner.nextInt();
            set.add(arrayB[i]);
        }
        Integer[] result = new Integer[set.size()];
        result = (Integer[])set.toArray(new Integer[set.size()]);
        Arrays.sort(result);
        String temp = "";
        for (int i = 0; i < result.length; i++) {
            temp += i;
            if(i != result.length-1)
                temp += " ";
        }
    }

}

