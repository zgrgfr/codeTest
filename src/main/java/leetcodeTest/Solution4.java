package leetcodeTest;

/**
 * 使用 排序插入 排序链表。
 *
 * Created by guofengrui on 2017/6/2.
 */
public class Solution4 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // 链表的头结点
        ListNode initNode = new ListNode(head.val);
        // 遍历插入的链表
        for(ListNode i = head.next; i != null;i = i.next){
            // 比当前的头结点的值小的情况
            if(i.val < initNode.val){
                ListNode node1 = new ListNode(initNode.val);
                ListNode node2 = new ListNode(i.val);
                node1.next = initNode.next;
                node2.next = node1;
                initNode = node2;
            }else{
                ListNode j = initNode;
                // 找到下一个结点大于i的值的结点
                while(j.next!= null && (j.next.val < i.val)){
                    j = j.next;
                }
                ListNode node = new ListNode(i.val);
                node.next = j.next;
                j.next = node;
            }
        }
        return initNode;
    }
}
