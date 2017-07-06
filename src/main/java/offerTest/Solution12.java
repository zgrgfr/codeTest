package offerTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * Created by guofengrui on 2017/6/1.
 */
public class Solution12 {
    List<Integer> list = new LinkedList<Integer>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if(list.size() == 0)
            return null;
        if(list.size() % 2 == 0){
            Double a = new Double(list.get(list.size()/2-1));
            Double b = new Double(list.get(list.size()/2));
            return  (a+b)/2;
        }else{
            return new Double(list.get((list.size()+1)/2-1));
        }
    }
}
