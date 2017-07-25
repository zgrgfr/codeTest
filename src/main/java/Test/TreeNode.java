package Test;

/**
 * Created by guofengrui on 2017/7/7.
 */

/**
 * 测试树：
 *           TreeNode node1 = new TreeNode(5);
             TreeNode node2 = new TreeNode(3);
             TreeNode node3 = new TreeNode(2);
             TreeNode node4 = new TreeNode(4);
             TreeNode node5 = new TreeNode(7);
             TreeNode node6 = new TreeNode(6);
             TreeNode node7 = new TreeNode(8);
             node1.left = node2;
             node1.right = node5;
             node2.left = node3;
             node2.right = node4;
             node5.left = node6;
             node5.right = node7;
 */
public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
}
