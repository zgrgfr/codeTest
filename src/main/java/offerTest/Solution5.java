package offerTest;


import java.util.List;

/**
 * 删除链表中重复的结点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * Created by guofengrui on 2017/5/24.
 */
public class Solution5 {
    public static  ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null)
            return pHead;
        if(pHead != null && pHead.next == null)
            return pHead;
        ListNode current ;
        if(pHead.next.val == pHead.val){
            current = pHead.next.next;
            while (current != null && current.val == pHead.val){
                current = current.next;
            }
            return deleteDuplication(current);
        }else{
            current = pHead.next;
            pHead.next = deleteDuplication(current);
            return pHead;
        }
    }


}
