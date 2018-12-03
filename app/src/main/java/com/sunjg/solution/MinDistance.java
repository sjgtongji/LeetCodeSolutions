package com.sunjg.solution;

/**
 * 583.给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * 说明:
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 */
public class MinDistance {
  public int minDistance(String word1, String word2) {
    if(word1 == null && word2 == null){
      return 0;
    }

    if(word1 == null || word2 ==  null){
      return 0;
    }

    if(word1.isEmpty()){
      return word2.length();
    }
    if(word2.isEmpty()){
      return word1.length();
    }

    int[][] matrix = new int[word1.length()][word2.length()];
    for(int i = 0 ; i < word1.length() ; i++){
      for(int j = 0 ; j < word2.length() ; j++){
        matrix[i][j] = word1.charAt(i) == word2.charAt(j) ? 1 : 0;
      }
    }



    return 0;
  }
}
