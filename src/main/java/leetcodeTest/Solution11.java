package leetcodeTest;

/**
 *  沿循环路线 有N个加油站，加油站的汽油量是gas[i]的。
    你有一辆带有无限气罐的汽车，从i站到下一站(i+1)要花费cost[i]汽油量。您在一个加油站开一个空的油箱的旅程。
    如果您可以在电路周围行驶一次，返回起始加油站的索引，否则返回-1。
 *
 * 结果唯一
 * Created by guofengrui on 2017/6/20.
 */
public class Solution11 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0)
            return -1;
        // 若能走完全程，则该坐标的下一个便是结果
        int index = -1;
        // 能否走完全程
        int total = 0;
        int remain = 0;
        for(int i=0; i<gas.length ;i++){
            total += (gas[i] - cost[i]);
            remain += (gas[i] - cost[i]);

            if(remain < 0){
                remain = 0;
                index = i;
            }
        }
        return total >= 0 ? index+1 : -1;
    }
}
