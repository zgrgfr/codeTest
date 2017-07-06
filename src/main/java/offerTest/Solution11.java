package offerTest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * Created by guofengrui on 2017/6/1.
 */
public class Solution11 {
    List<TreeNode> list = new ArrayList<TreeNode>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null)
            return null;
        orderSort(pRoot);
        if(k <= list.size() && k > 0){
            return list.get(k-1);
        }else {
            return null;
        }

    }
    // 中序遍历得到值的集合
    void orderSort(TreeNode node){
        if(node != null){
            orderSort(node.left);
            list.add(node);
            orderSort(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
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
        Solution11 solution11 = new Solution11();
        solution11.KthNode(node1,3);
    }
}
