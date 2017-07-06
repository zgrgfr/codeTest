package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 2D坐标系上有一些点，要求返回连成一条直线时所包含的最多的点数
 *
 * Created by guofengrui on 2017/6/1.
 */
public class Solution2 {
    public int maxPoints(Point[] points) {
        Double k ;
        int x, y, max = 0;
        for (int i = 0; i < points.length ; i++) {
            // 重复的点
            int repeat = 0;
            // 当前点的连线的最大值
            int curMax = 1;
            Map<Double,Integer> map = new HashMap<Double, Integer>();
            x = points[i].x;
            y = points[i].y;
            for (int j = i+1; j <points.length ; j++) {
                int num = 1;
                if(points[j].x == x && points[j].y == y)
                    repeat += 1;
                else{
                    if(points[j].x != x)
                        if(points[j].y == y) k = 0.0;
                        else k = 1.0*(y - points[j].y) / (x - points[j].x);
                    else
                        k = Double.MAX_VALUE;

                    if(map.get(k) != null)
                        num = map.get(k) + 1;
                    else
                        num = 2;
                    map.put(k,num);
                }
                if(curMax < num) curMax = num;
            }
            curMax += repeat;
            if(max < curMax) max = curMax;
        }
        return max;
    }
}
