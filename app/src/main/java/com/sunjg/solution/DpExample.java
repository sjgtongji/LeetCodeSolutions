package com.sunjg.solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 动态规划样例
 */
public class DpExample {

  //树塔问题
  public int getMaxSum(int maxLevel , int[][] values){
    int[][] dp = new int[maxLevel][maxLevel];
    for(int i = 0 ; i < values[maxLevel - 1].length ; i++){
      dp[maxLevel - 1][i] = values[maxLevel - 1][i];
    }
    for(int i = maxLevel - 2 ; i >=0 ; i--){
      for(int j = 0 ; j < i + 1 ; j++){
        int max = dp[i+1][j] > dp[i+1][j+1]? dp[i+1][j] : dp[i+1][j+1];
        int cur = dp[i+1][j] > dp[i+1][j+1]? values[i+1][j] : values[i+1][j+1];
        dp[i][j] = max + values[i][j];
      }
    }
    return dp[0][0];
  }

  //最长上升子序列
  public int getMaxAscArray(int n , int[] array){
    int[] dp = new int[n];
    dp[n - 1] = 1;
    for(int i = n - 2 ; i  >= 0 ; i --){
      dp[i] = array[i] < array[i+1]? 1 + dp[i+1] : dp[i+1];
    }
    return dp[0];
  }

  public int subarrayBitwiseORs(int[] A) {
    if(A == null || A.length == 0){
      return 0;
    }
    Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2 = new HashSet<>();
    for(int i : A){
      cur2 = new HashSet<>();
      cur2.add(i);
      for(Integer j : cur){
        cur2.add(i | j);
      }
      cur = cur2;
      for(Integer k : cur){
        System.out.print(k + " ");
        res.add(k);
      }
      System.out.println();
    }
    return res.size();
  }

  public int knightDialer(int N) {
    if(N == 0){
      return 0;
    }
    if(N == 1){
      return 10;
    }
    int[][] paths = new int[][]{
      new int[]{4 , 6},
      new int[]{6 , 8},
      new int[]{7 , 9},
      new int[]{4 , 8},
      new int[]{0 , 3 , 9},
      new int[]{},
      new int[]{0 , 1 , 7},
      new int[]{2 , 6},
      new int[]{1 , 3},
      new int[]{2 , 4}
    };
    int[][] dp = new int[10][N];
    dp[0][0] = 1;
    dp[1][0] = 1;
    dp[2][0] = 1;
    dp[3][0] = 1;
    dp[4][0] = 1;
    dp[5][0] = 1;
    dp[6][0] = 1;
    dp[7][0] = 1;
    dp[8][0] = 1;
    dp[9][0] = 1;
    for(int i = 1 ; i < N ; i++){
      for(int j = 0 ; j < 10 ; j++){
        dp[j][i] = 0;
        for(int k : paths[j]){
          dp[j][i] += dp[k][i-1];
          if(dp[j][i] >= mode){
            dp[j][i] %= mode;
          }
        }
      }
    }
    int result = 0;
    for(int i = 0 ; i < 10 ; i++){
      result += dp[i][N - 1];
      if(result >= mode){
        result %= mode;
      }
    }
    return result;

//    int[] dp = new int[N];
//    HashSet<Integer>[] node = new HashSet[N];
//    dp[0] = 10;
//    node[0] = new HashSet<>(Arrays.asList( 0 , 1 , 2 , 3 , 4, 5 ,6 ,7 ,8 ,9 ,10));
//    int result = 0;
//    for(Integer i : node[0]){
//      result += paths[i].size();
//      node[1].addAll(paths[i]);
//    }
//    dp[1] = result;
  }
  int mode = (int)Math.pow(10 , 9) + 7;


}
