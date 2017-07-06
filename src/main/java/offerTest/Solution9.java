package offerTest;

import java.util.ArrayList;

/**
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * Created by guofengrui on 2017/5/31.
 */
public class Solution9 {
    // 每一层都存放在一个集合中
    ArrayList<ArrayList<TreeNode>> treeList = new ArrayList<ArrayList<TreeNode>>();
    // 返回的结果集
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null)
            return result;
        ArrayList<TreeNode> node = new ArrayList<TreeNode>();
        node.add(pRoot);
        treeList.add(node);
        addInteger(treeList.get(0),1);
        return result;
    }

    public void addInteger(ArrayList<TreeNode> list,int size){

            ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                // 构建层的集合
                if(list.get(i).left != null)
                    list1.add(list.get(i).left);
                if(list.get(i).right != null)
                    list1.add(list.get(i).right);
                // 放入结果集中的数
                list2.add(list.get(i).val);
            }
            if(list1 != null && list1.size() != 0)
                treeList.add(list1);
            result.add(list2);
            if(treeList.size() > size)
                addInteger(treeList.get(treeList.size()-1),treeList.size());
        }
}
