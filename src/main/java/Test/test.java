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
        for (double i = 2; i <=200 ; i++) {
            boolean flag = true;
            for(double j = 2;j<200; j++){
                if(i%j == 0 && i != j){
                    flag = false;
                }
            }
            if (flag)
                System.out.println(i);
        }

    }

}

