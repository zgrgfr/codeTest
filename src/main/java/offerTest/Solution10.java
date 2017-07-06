package offerTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ServiceConfigurationError;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * Created by guofengrui on 2017/5/31.
 */
public class Solution10 {
    int i = -1;
    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if(root == null){
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }else{
            stringBuilder.append(root.val).append(",");
            stringBuilder.append(Serialize(root.left));
            stringBuilder.append(Serialize(root.right));
            return stringBuilder.toString();
        }
    }
    TreeNode Deserialize(String str) {
        i++;
        String[] array = str.split(",");
        TreeNode root = null;
        if(!"#".equals(array[i])){
            root = new TreeNode(Integer.parseInt(array[i]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
