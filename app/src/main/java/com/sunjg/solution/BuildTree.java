package com.sunjg.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 105根据二叉树的前序和中序遍历构造二叉树
 */
public class BuildTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length){
      return null;
    }
    return buildTree(preorder , inorder , 0 , preorder.length - 1 , 0 , inorder.length - 1);
  }

  public TreeNode buildTree(int[] preorder , int[] inorder , int prestart , int preend , int instart , int inend){
    if(preend < prestart || inend < instart){
      return null;
    }
    if(prestart - preend == 0 && inend - instart == 0 && preorder[prestart] == inorder[instart]){
      return new TreeNode(preorder[prestart]);
    }
    System.out.println(prestart + "|" + preend + "|" + instart + "|" + inend);
    int inRootIndex = find(inorder , preorder[prestart]);
    int inLeftStart = instart;
    int inLeftEnd = inRootIndex - 1 >= instart ? inRootIndex - 1 : instart;
    int inRightStart = inRootIndex + 1 <= inend ? inRootIndex + 1 : inend;
    int inRightEnd = inend;

    int preLeftStart = prestart + 1 <= preend ? prestart + 1 : preend;
    int preLeftEnd = preLeftStart + (inLeftEnd - inLeftStart) <= preend ? preLeftStart + (inLeftEnd - inLeftStart): preLeftStart;
    int preRightStart = preLeftEnd + 1 <= preend ? preLeftEnd + 1 : preend;
    int preRightEnd = preend;
    TreeNode root = new TreeNode(preorder[prestart]);
    root.left = buildTree(preorder , inorder , preLeftStart , preLeftEnd , inLeftStart , inLeftEnd);
    root.right = buildTree(preorder , inorder , preRightStart , preRightEnd , inRightStart , inRightEnd);
    return root;
  }

  public void print(int[] a){
    for(int i : a){
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public int find(int[] arr , int ele){
    for(int i = 0 ; i < arr.length ; i++){
      if(ele == arr[i]){
        return i;
      }
    }
    return -1;
  }
}
