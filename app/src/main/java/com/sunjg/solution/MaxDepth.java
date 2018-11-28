package com.sunjg.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: MaxDepth
 * @Description: java类作用描述
 * @Author: jigangsun
 * @Date: 2018/11/26 上午11:06
 */
public class MaxDepth {
  public int maxDepth(TreeNode root) {
    int height=0;int r=0;int l=0;
    if(root==null)
      return 0;
    r=maxDepth(root.left);
    l=maxDepth(root.right);
    return l>r?l+1:r+1;
  }
}
