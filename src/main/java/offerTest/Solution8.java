package offerTest;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * Created by guofengrui on 2017/5/25.
 */
public class Solution8 {
    // 每一层都存放在一个集合中
    ArrayList<ArrayList<TreeNode>> treeList = new ArrayList<ArrayList<TreeNode>>();
    // 返回的结果集
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    // 定义一个标志位，true正序，false逆序
    boolean flag = true;
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null)
            return result;
        ArrayList<TreeNode> node = new ArrayList<TreeNode>();
        node.add(pRoot);
        treeList.add(node);
        addInteger(treeList.get(0), true,1);
        return result;
    }

    public void addInteger(ArrayList<TreeNode> list,boolean flag,int size){
        if(flag){
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
            flag = false;
            if(treeList.size() > size)
                addInteger(treeList.get(treeList.size()-1),flag,treeList.size());
        }else{
            ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).left != null)
                    list1.add(list.get(i).left);
                if(list.get(i).right != null)
                    list1.add(list.get(i).right);
                list2.add(list.get(i).val);
            }
            // list翻转
            Collections.reverse(list2);
            if(list1 != null && list1.size() != 0)
                treeList.add(list1);
            result.add(list2);
            flag = true;
            if(treeList.size() > size)
                addInteger(treeList.get(treeList.size()-1),flag,treeList.size());
        }
    }
}
