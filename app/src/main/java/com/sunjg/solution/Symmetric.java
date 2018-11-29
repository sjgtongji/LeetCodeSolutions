package com.sunjg.solution;

/**
 * 检查二叉树是否镜像对称
 */
public class Symmetric {
  public boolean isSymmetric(TreeNode root) {
    if(root == null){
      return true;
    }
    return isSymmetric(root.left , root.right);
  }

  public boolean isSymmetric(TreeNode left , TreeNode right){
    if(left == null){
      return right == null;
    }else if(right == null){
      return false;
    }else{
      return left.val == right.val && isSymmetric(left.left , right.right) && isSymmetric(left.right , right.left);
    }
  }
}
