package leetcodeTest;

/**
 *
    使用恒定空间复杂度在O（n log n）时间内对链表进行排序。
 *
 * Created by guofengrui on 2017/6/2.
 */
public class Solution3 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // 中间的结点
        ListNode node = getMiddle(head);
        ListNode node2 = node.next;
        // 断开这个链表
        node.next = null;
        return mergeTwoLists(sortList(head),sortList(node2));
    }

    // 取得中间的结点
    private ListNode getMiddle(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 实现合并两个已经排序的链表
    private ListNode mergeTwoLists(ListNode l1 , ListNode l2){
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        ListNode first = l1.next;
        ListNode second = l2.next;
        // res操作链表，result返回结果
        ListNode res , result ;
        if(l1.val < l2.val){
            result = res = l1;
            second = l2;
        }else{
            result = res = l2;
            first = l1;
        }
        // 归并两条有序链表
        while(first != null || second != null){
            if(first == null){
                res.next = second;
                return result;
            }else if(second == null){
                res.next = first;
                return result;
            }else if(first.val < second.val){
                res.next = first;
                first = first.next;
                res = res.next;
            }else{
                res.next = second;
                second = second.next;
                res = res.next;
            }
        }
        return result;
    }
}
