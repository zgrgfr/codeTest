package leetcodeTest;

/**
 * 最小深度的二叉树
 *
 * 给定一个二叉树，找到其最小深度。最小深度是从根节点到最近叶节点的最短路径的节点数。
 * Created by guofengrui on 2017/6/1.
 */
public class Solution1 {
    public int run(TreeNode root) {
        if(root == null)
            return 0;
        return getMin(root,1);
    }
    // 结点的最小深度就是  结点的左结点的最小深度，结点的右结点的最小深度中的最小值+1
    public int getMin(TreeNode node,int number){
        if(node.left != null && node.right != null)
            return number + Math.min(getMin(node.left,1),getMin(node.right,1));
        if(node.left != null && node.right == null)
            return number + getMin(node.left,1);
        if (node.left == null && node.right != null)
            return number + getMin(node.right,1);
        if(node.left == null && node.right == null)
            return number;
        return number;
    }
}
