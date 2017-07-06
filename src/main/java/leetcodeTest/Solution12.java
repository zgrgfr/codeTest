package leetcodeTest;

/**
 *
     给定一个字符串s，分区使得分区的每个子字符串都是回文。
     返回对于s的回文分割所需的最小削减 。
     例如，给定s =“aab”，
     返回1可以使用1切割生成回文分割[“aa”，“b”]。
 *
 * Created by guofengrui on 2017/6/30.
 */
public class Solution12 {
    public static int minCut(String s) {
        // dp[i]表示0 - i 的最小切割
        int[] dp = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i] = isPalindrome(s.substring(0,i+1))? 0 : i;
            if(dp[i] == 0)
                continue;
            for(int j=1; j<=i ; j++){
                if(isPalindrome(s.substring(j,i+1))){
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }else{
                    dp[i] = Math.min(dp[i],dp[j-1]+i+1-j);
                }
            }
        }
        return dp[s.length()-1];
    }

    // 是否是回文序列，是返回true
    private static boolean isPalindrome(String s){
        boolean flag = true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String str = "aabcdaa";
        System.out.println(Solution12.minCut(str));
    }
}
