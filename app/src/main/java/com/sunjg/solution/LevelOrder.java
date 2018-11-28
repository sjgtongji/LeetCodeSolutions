package com.sunjg.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: LevelOrder
 * @Description: java类作用描述二叉树广度优先遍历
 * @Author: jigangsun
 * @Date: 2018/11/23 下午3:36
 */
public class LevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> rootLevel = new ArrayList<>();
    List<List<TreeNode>> nodes = new ArrayList<>();
    List<TreeNode> rootLevelNodes = new ArrayList<>();
    rootLevelNodes.add(root);
    nodes.add(rootLevelNodes);
    rootLevel.add(root.val);
    result.add(rootLevel);
    for(int i = 0 ; i < nodes.size() ; i++){
      List<TreeNode> level = nodes.get(i);
      List<Integer> valueLevel = new ArrayList<>();
      List<TreeNode> nodeLevel = new ArrayList<>();
      for(TreeNode node : level){
        if(node.left != null){
          nodeLevel.add(node.left);
          valueLevel.add(node.left.val);
        }
        if(node.right != null){
          nodeLevel.add(node.right);
          valueLevel.add(node.right.val);
        }
      }
      if(nodeLevel != null && nodeLevel.size() > 0){
        nodes.add(nodeLevel);
        result.add(valueLevel);
      }
    }
    return result;
  }

  public void print(List<List<Integer>> lists){
    for(List<Integer> list : lists){
      for(Integer i : list){
        System.out.print(i);
      }
      System.out.println();
    }
    System.out.println();
  }
}
