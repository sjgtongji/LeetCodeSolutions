package com.sunjg.solution;

/**
 * @ClassName: AddOneRow
 * @Description: java类作用描述
 * @Author: jigangsun
 * @Date: 2018/11/26 下午4:45
 */
public class AddOneRow {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if(root == null){
      return  root;
    }

    if(d == 1){
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }
    addOneRow(root , v , d , 2);
    return root;
  }

  public void addOneRow(TreeNode root, int v, int d , int level){
    if(level < d){
      if(root.left != null){
        addOneRow(root.left , v , d , level + 1);
      }

      if(root.right != null){
        addOneRow(root.right , v , d , level + 1);
      }
    }else if(level == d){
      TreeNode v1 = new TreeNode(v);
      TreeNode v2 = new TreeNode(v);
      v1.left = root.left;
      v2.right = root.right;
      root.left = v1;
      root.right = v2;
    }
  }
}
