package leetcodeTest;

/**
 * 链表周期
 *
 * 给定一个链表，返回循环开始的节点。如果没有循环，returnnull。
 * Created by guofengrui on 2017/6/6.
 */
public class Solution6 {
    /*快慢指针第一次相遇的点定为N1，两个慢指针分别从起点和N1开始运动，
    再次相遇的点就是环入口，在找N1的过程中出现NULL则说明没有环*/
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
