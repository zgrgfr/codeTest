package Test;
import Test.ListNode;

import java.util.Stack;
import java.util.ArrayList;
/**
 * Created by guofengrui on 2017/7/3.
 */
public class test {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int i = 1;
        while(i < k){
            if(fast != null){
                fast = fast.next;
                i++;
                if(fast == null){
                    return null;
                }
            }
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

