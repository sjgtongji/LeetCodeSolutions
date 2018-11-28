package com.sunjg.solution;

/**
 * @ClassName: MinDepth
 * @Description: java类作用描述
 * @Author: jigangsun
 * @Date: 2018/11/26 上午9:28
 */
public class MinDepth {
  public int minDepth(TreeNode root) {
    if(root == null){
      return 0;
    }
    return minDepth(root , 1);
  }

  public int minDepth(TreeNode root , int depth){
    if(root.left == null && root.right == null){
      return depth;
    }
    if(root.left != null && root.right != null){
      return Math.min(minDepth(root.left , depth + 1) , minDepth(root.right , depth + 1));
    }
    if(root.left == null && root.right != null){
      return minDepth(root.right , depth + 1);
    }
    return minDepth(root.left , depth + 1);
  }
}
