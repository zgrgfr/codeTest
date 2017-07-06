package leetcodeTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Set;

/**
 *   给定一个字符串s和一个单词dict的字典，在s中添加空格来构造一个句子，其中每个单词都是有效的字典单词。
     返回所有这样的句子。
     例如，给定
     s =“catsanddog”，
     dict = [“cat”，“cats”，“and”，“sand”，“dog”]。
     解决方案是["cats and dog", "cat sand dog"]。
 *
 * Created by guofengrui on 2017/6/8.
 */
public class Solution7 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = Lists.newArrayList();
        if("".equals(s) || s == null || dict.size() == 0 || dict == null)
            return result;
        // 将字符串从分割点i处切割为两部分左边s1和右边s2，
        // 如果s1包含在字典中，则递归计算s2切割生成的字符串
        // 用flag[i]==true表示从i位置往后分割不出满足条件的串
        // flag[i]==true的情况就不需要递归计算了，从而降低运算时间
        boolean[] flag = new boolean[s.length()];
        help(s,result,flag,"",0,dict);
        return result;
    }

    /**
     *
     * @param s 要匹配的字符串
     * @param result 结果集
     * @param flag 每个字符位置代表的之后字符串的是否可分
     * @param before 之前得到的符合dict的字符串
     * @param begin 开始的位置下标
     * @param dict 题目给的集合
     */
    private void help(String s,ArrayList<String> result,boolean[] flag,String before,int begin,Set<String> dict){
        for(int i = begin+1; i <= s.length() ;i++){
            String temp = before;
            // 如果包含这个字符串
            if(dict.contains(s.substring(begin,i))){
                // 如果这个是最后一个字符串
                if(i == s.length()){
                    temp += s.substring(begin,i);
                    result.add(temp);
                }else{
                    // 后面的字符串中还有要的字符串
                    if(!flag[begin]){
                        int size = result.size();
                        temp += s.substring(begin,i) + " ";
                        help(s,result,flag,temp,i,dict);
                        // 当递归前后result的size没有变化，说明i后不可分割
                        if(size == result.size()){
                            flag[i] = true;
                        }
                    }
                }
            }
        }
    }
}
