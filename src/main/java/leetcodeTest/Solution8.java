package leetcodeTest;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 *
 *   给定一个字符串s和一个词dict的字典，确定s可以被分割成一个或多个字典单词的空格分隔的序列。
     例如，给定
     s =“leetcode”，
     dict = [“leet”，“code”]。
     返回true，因为“leetcode”可以被分割为“leet code”。

 * Created by guofengrui on 2017/6/8.
 */
public class Solution8 {
    public static boolean wordBreak(String s, Set<String> dict) {
        // dp[i]表示字符串s[0~i]是否可分的bool值
        if(s == null || "".equals(s) )
            return true;
        if(dict == null ||dict.size() == 0)
            return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length();i++){
            for(int j=0;j<s.length();j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "a";
        Set<String> set = Sets.newHashSet();
        set.add("a");
        System.out.println(Solution8.wordBreak(s,set));
    }
}