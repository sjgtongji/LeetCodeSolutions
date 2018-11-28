package com.sunjg.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LowestCommonAncestor
 * @Description: java类作用描述 二叉树最近公共祖先
 * @Author: jigangsun
 * @Date: 2018/11/23 下午2:40
 */
public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pParents = getParentArray(root , p);
    List<TreeNode> qParents = getParentArray(root , q);
    for(TreeNode pNode : pParents){
      for(TreeNode qNode : qParents){
        if(pNode.val == qNode.val){
          System.out.println(pNode.val);
          return pNode;
        }
      }
    }
    System.out.println(root.val);
    return root;
  }
  //二叉搜索树最近公共祖先
//  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//      if(root == null || p == null || q == null){
//        return null;
//      }
//
//      if(p.val < root.val && q.val < root.val){
//        return lowestCommonAncestor(root.left , p , q);
//      }else if(p.val > root.val && q.val > root.val){
//        return lowestCommonAncestor(root.right , p , q);
//      }else{
//        System.out.println(root.val);
//        return root;
//      }
//  }

  public List<TreeNode> getParentArray(TreeNode root , TreeNode node){
    List<TreeNode> result = new ArrayList<>();
    getParentArray(root , node , result);
    return result;
  }

  private boolean getParentArray(TreeNode root , TreeNode node , List<TreeNode> list){
    if(root == null){
      return false;
    }
    if(node.val == root.val){
      list.add(node);
      return true;
    }else{
      if(getParentArray(root.left , node , list)){
        list.add(root);
        return true;
      }else if(getParentArray(root.right , node , list)){
        list.add(root);
        return true;
      }else{
        return false;
      }
    }
  }
  public void print(List<TreeNode> nodes){
    for(TreeNode node : nodes){
      System.out.print(node.val);
    }
    System.out.println();
  }
}
