package com.sunjg.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrder {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null){
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> rootLevel = new ArrayList<>();
    List<List<TreeNode>> nodes = new ArrayList<>();
    List<TreeNode> rootLevelNodes = new ArrayList<>();
    rootLevelNodes.add(root);
    nodes.add(rootLevelNodes);
    rootLevel.add(root.val);
    result.add(rootLevel);
    boolean isInOrder = true;
    for(int i = 0 ; i < nodes.size() ; i++){
      isInOrder = i % 2 != 0;
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
        if(isInOrder){
          result.add(valueLevel);
        }else{
          Collections.reverse(valueLevel);
          result.add(valueLevel);
        }

      }
    }
    return result;
  }
}
