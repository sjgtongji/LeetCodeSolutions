package com.sunjg.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: java类作用描述
 * @Author: jigangsun
 * @Date: 2018/11/23 下午2:39
 */
public class Solution {
  public static void main(String[] args){
    //二叉树的最小公共祖先
//    TreeNode A = new TreeNode(3);
//    TreeNode B = new TreeNode(9);
//    TreeNode D = new TreeNode(20);
//    TreeNode G = new TreeNode(15);
//    TreeNode H = new TreeNode(7);
//    A.left = B;
//    A.right = D;
//    D.left = G;
//    D.right = H;
//    List<List<Integer>> res = new ZigzagLevelOrder().zigzagLevelOrder(A);
//    for(List<Integer> list : res){
//      for(Integer i : list){
//        System.out.print(i);
//      }
//      System.out.println();
//    }
    int[] preorder = new int[]{1, 2};
    int[] inorder = new int[]{2, 1};
    print(new BuildTree().buildTree(preorder , inorder));
//
//    A.left = B;
//    B.left = D;
//    B.right = E;
//    D.right = E;
//    E.left = F;
//    F.right = G;
//    G.left = J;
//    J.right = K;
//    LowestCommonAncestor ancestor = new LowestCommonAncestor();
//    ancestor.lowestCommonAncestor(A , B , C);
//    LevelOrder levelOrder = new LevelOrder();
//    levelOrder.print(levelOrder.levelOrder(A));
//    MinDepth minDepth = new MinDepth();
//    System.out.println(minDepth.minDepth(A));
//    SumOfDistancesInTree sum = new SumOfDistancesInTree();
//    int[][] edges = new int[][]{new int[]{0,1},new int[]{0,2},new int[]{2,3}, new int[]{2,4},new int[]{2,5}};
//    sum.print(sum.sumOfDistancesInTree(6 , edges));

    //树塔问题
//    int[][] values = new int[3][3];
//    values[0][0] = 13;
//    values[1][0] = 12;
//    values[1][1] = 7;
//    values[2][0] = 9;
//    values[2][1] = 10;
//    values[2][2] = 13;
//    DpExample dpExample = new DpExample();
//    System.out.println(dpExample.getMaxSum(3 , values));
//    int[] values = new int[]{4 , 2 , 6 , 1 ,5};
//    System.out.println(dpExample.getMaxAscArray(5  , values));
//    System.out.println(dpExample.subarrayBitwiseORs(new int[]{1, 2 , 4}));
//    System.out.println(dpExample.knightDialer(161));
  }

  public static void print(TreeNode root){
    if(root == null)
      return;
    Deque<List<TreeNode>> deque = new ArrayDeque<>();
    deque.add(Arrays.asList(root));
    while (!deque.isEmpty()){
      List<TreeNode> level = deque.poll();
      List<TreeNode> nextLevel = new ArrayList<>();
      for(TreeNode node : level){
        System.out.print(node.val + " ");
        if(node.left != null)
          nextLevel.add(node.left);

        if(node.right != null)
          nextLevel.add(node.right);
      }
      System.out.println();
      if(!nextLevel.isEmpty()){
        deque.add(nextLevel);
      }
    }
  }
}
