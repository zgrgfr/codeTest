package offerTest;

/**
 * (带有指向父结点指针)二叉树结点
 * Created by guofengrui on 2017/5/25.
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    // 指向父结点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
