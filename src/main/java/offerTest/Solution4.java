package offerTest;


import java.util.HashSet;

/**
 * 链表中环的入口接结点
 *
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * Created by guofengrui on 2017/5/24.
 */
public class Solution4 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;

        HashSet<ListNode> set = new HashSet<ListNode>();
        while(pHead != null){
            if(!set.add(pHead)){
                return pHead;
            }else{
                pHead = pHead.next;
            }
        }
        return null;
    }

}
