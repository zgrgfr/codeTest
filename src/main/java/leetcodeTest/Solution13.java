package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  给定一个字符串s，分区s使得分区的每个都是回文。
   返回的所有可能的回文分区。
   例如，给定 s =“AAB”，
 [
     [ “AA”， “B”]，
     [ “A”， “A”， “B”]
 ]
 * Created by guofengrui on 2017/6/30.
 */
public class Solution13 {
//    public static ArrayList<ArrayList<String>> partition(String s) {
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//        ArrayList<String> tempList = new ArrayList<String>();
//        if(s.length() == 0 || s == null ){
//            return result;
//        }
//        partition(tempList,result,s,0);
//        return result;
//    }
//
//    // 递归
//    private static void partition(ArrayList<String> tempList,ArrayList<ArrayList<String>> result, String str,int start){
//        int len = str.length();
//        if(len == start){
//            result.add(new ArrayList<String>(tempList));
//            return ;
//        }
//        for(int i = start+1; i<=len; i++){
//            String s = str.substring(start, i);
//            if(isPalindrome(s)){
//                tempList.add(s);
//                partition(tempList, result, str,i);
//                tempList.remove(tempList.size()-1);
//            }
//        }
//    }
//    // 是否是回文序列，是返回true
//    private static boolean isPalindrome(String s){
//        boolean flag = true;
//        for(int i=0,j=s.length()-1;i<j;i++,j--){
//            if(s.charAt(i) != s.charAt(j)){
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }
public static ArrayList<ArrayList<String>> partition(String s) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    ArrayList<String> temp = new ArrayList<String>();
    dfs(s, 0, temp, result);
    return result;
}
    private static void dfs(String s, int curIndex, ArrayList<String> temp, ArrayList<ArrayList<String>> result) {
        if (curIndex == s.length()) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = curIndex + 1; i <= s.length(); i++) {
            String prefix = s.substring(curIndex, i);
            if (!isPrlindrome(prefix))  //剪枝
                continue;
            temp.add(prefix);
            dfs(s, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    private static boolean isPrlindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abab";
        System.out.println(partition(str));
    }
}
