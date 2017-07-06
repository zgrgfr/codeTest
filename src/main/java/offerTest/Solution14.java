package offerTest;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * Created by guofengrui on 2017/6/1.
 */
public class Solution14 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 0表示这个格子没有走过，1表示已经走过
        int[] flag = new int[matrix.length];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(hasPath(matrix,rows,cols,i,j,str,0,flag))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPath(char[] matrix,int rows, int cols,int i, int j, char[] str, int k, int[] flag){
        int index = i * cols + j;
        if(i >= rows || i < 0 || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1){
            return false;
        }
        if(k == str.length-1) return true;
        // 表示走过
        flag[index] = 1;
        if(hasPath(matrix,rows,cols,i+1,j,str,k+1,flag)
                || hasPath(matrix,rows,cols,i-1,j,str,k+1,flag)
                || hasPath(matrix,rows,cols,i,j+1,str,k+1,flag)
                || hasPath(matrix,rows,cols,i,j-1,str,k+1,flag))
            return true;
        flag[index] = 0;
        return false;
    }
}
