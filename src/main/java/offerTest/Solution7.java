package offerTest;

/**
 * 对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * Created by guofengrui on 2017/5/25.
 */
public class Solution7 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            return true;
        return equals(pRoot.left,pRoot.right);
    }

    public boolean equals(TreeNode left,TreeNode right){
        if(left == null) return right==null;
        if(right == null)return false;
        if(left.val != right.val)return false;
        // 左子树的左子树和右子树的右子树相同
        // 左子树的右子树和右子树的左子树相同
        return equals(left.right,right.left) && equals(left.left,right.right);
    }
}
