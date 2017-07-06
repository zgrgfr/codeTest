package leetcodeTest;

import java.util.Stack;

/**重排列表
 *
 * L0→L1→…→Ln-1→Ln =》
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 *Given{1,2,3,4,5,6}, reorder it to{1,6,2,5,3,4}.
 *
 * Created by guofengrui on 2017/6/6.
 */
public class Solution5 {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode node = getMiddle(head);
        ListNode middle = node.next;
        // 把链表切成两段
        node.next = null;
        ListNode overMiddle = overturn(middle);
        ListNode node2 = head;
        ListNode result = head;
        while(overMiddle != null){
            ListNode newNode = new ListNode(overMiddle.val);
            newNode.next = node2.next;
            node2.next = newNode;
            node2 = newNode.next;
            overMiddle = overMiddle.next;
        }
    }

    // 取得中间点
    private ListNode getMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 将链表翻转
    private ListNode overturn(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode result = new ListNode(stack.peek().val);
        ListNode node = result;
        stack.pop();
        while(stack != null && stack.size() != 0){
            node.next = new ListNode(stack.peek().val);
            node = node.next;
            stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution5 solution5 = new Solution5();
        solution5.reorderList(node1);
    }
}
