package offerTest;

/**
 * 字符流中第一个不重复的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
    如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * Created by guofengrui on 2017/5/24.
 */
public class Solution3 {
    StringBuilder s = new StringBuilder();
    int [] array = new int[256];
    public void Insert(char ch) {
        s.append(ch);
        if(array[ch] == 0){
            array[ch] = 1;
        }else{
            array[ch] += 1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chArray = s.toString().toCharArray();
        for (int i = 0; i <chArray.length ; i++) {
            if(array[chArray[i]] == 1){
                return chArray[i];
            }
        }
        return '#';
    }
}
