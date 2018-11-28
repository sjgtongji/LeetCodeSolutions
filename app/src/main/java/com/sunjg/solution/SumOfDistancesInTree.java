package com.sunjg.solution;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

public class SumOfDistancesInTree {
  private static class Path{
    public int from;
    public int to;

    public Path(int from, int to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
      if(!(obj instanceof Path)){
        return false;
      }
      Path p = (Path) obj;
      return (p.from == this.from && p.to == this.to) || (p.from == this.to && p.to == this.from);
    }
  }

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    Map<Path , Integer> paths = new HashMap<>();
    for(int i = 0 ; i < edges.length ; i++){
      paths.put(new Path(edges[i][0] , edges[i][1]) , 1);
    }
    int[] result = new int[N];
    for(int i = 0 ; i < N ; i++){
      result[i] = 0;
      for(int j = 0 ; j < N ; j++){
        if(i != j){
          result[i] += getDistanceBetweenTwo(edges , i , j , paths);
        }
      }
    }
    return result;
  }

  public int getDistanceBetweenTwo(int[][] edges , int from , int to , Map<Path , Integer> paths){
    Path path = new Path(from , to);
    if(paths.containsKey(path)){
      return paths.get(path);
    }else{
      int result = getDistanceBetweenTwo(edges , from , to , -1 , paths);
      paths.put(path , result);
      return result;
    }
  }
  public int getDistanceBetweenTwo(int[][] edges , int from , int to , int lastIndex, Map<Path , Integer> paths){
    Path path = new Path(from , to);
    if(paths.containsKey(path)){
      return paths.get(path);
    }
    int minDistance = Integer.MAX_VALUE;
    boolean hasNextPath = false;
    for(int i = 0 ; i < edges.length ; i++){
      int[] edge = edges[i];
      if(i != lastIndex){
        if(from == edge[0] && to != edge[1]){
          int distance = 1 + getDistanceBetweenTwo(edges , edge[1] , to , i , paths);
          hasNextPath = true;
          minDistance = minDistance < distance ? minDistance : distance;
        }else if(from == edge[1] && to != edge[0]){
          int distance = 1 + getDistanceBetweenTwo(edges , edge[0] , to , i , paths);
          hasNextPath = true;
          minDistance = minDistance < distance ? minDistance : distance;
        }else if((from == edge[1] && to == edge[0]) || (from == edge[0] && to == edge[1])){
          hasNextPath = true;
          minDistance = 1;
        }
      }
    }

    if(!hasNextPath){
      return 10001;
    }
    paths.put(path , minDistance);
    return minDistance;
  }

  public void print(int[] result){
    for(int i = 0 ; i < result.length ; i++){
      System.out.println(result[i]);
    }
    System.out.println();
  }
}
