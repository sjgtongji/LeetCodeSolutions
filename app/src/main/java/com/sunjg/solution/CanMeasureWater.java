package com.sunjg.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;

/**
 * 365.水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class CanMeasureWater {
  //Y_CAP > X_CAP
  public static int X_CAP;
  public static int Y_CAP;
  class State{
    private int x;
    private int y;
    public State(int x , int y){
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
      if(!(obj instanceof State)){
        return false;
      }
      State s1 = (State) obj;
      return this.x == s1.x && this.y == s1.y;
    }

    @Override
    public int hashCode() {
      return 1;
    }

    public State fillX(){
      return new State(X_CAP , this.y);
    }

    public State fillY(){
      return new State(this.x , Y_CAP);
    }

    public State emptyX(){
      return new State(0 , this.y);
    }

    public State emptyY(){
      return new State(this.x , 0);
    }

    public State x2YUntilXEmpty(){
      int nextY = this.y + this.x <= Y_CAP ? this.y + this.x : Y_CAP;
      return new State(0 , nextY);
    }

    public State x2YUntilYFull(){
      int nextY = this.x + this.y > Y_CAP ? Y_CAP : this.x + this.y ;
      int nextX = this.x + this.y > Y_CAP ? this.x + this.y - Y_CAP : 0;
      return new State(nextX , nextY);
    }

    public State y2XUntilYEmpty(){
      int nextY = 0;
      int nextX = this.x + this.y > X_CAP ? X_CAP : this.x + this.y;
      return new State(nextX , nextY);
    }

    public State y2XUntilXFull(){
      int nextY = this.x + this.y > X_CAP ? this.x + this.y - X_CAP : 0;
      int nextX = this.x + this.y > X_CAP ? X_CAP : this.x + this.y;
      return new State(nextX , nextY);
    }

    public Set<State> nextStateList(){
      Set<State> nextStateList = new HashSet<>();
      nextStateList.add(fillX());
      nextStateList.add(emptyX());
      nextStateList.add(fillY());
      nextStateList.add(emptyY());
      nextStateList.add(x2YUntilXEmpty());
      nextStateList.add(x2YUntilYFull());
      nextStateList.add(y2XUntilXFull());
      nextStateList.add(y2XUntilYEmpty());
      return nextStateList;
    }
  }
  public boolean canMeasureWater(int x, int y, int z) {
    return x + y >= z && z % gcd( x < y ? x : y , x < y ? y :x) == 0;
//    X_CAP = x < y ? x : y;
//    Y_CAP = x < y ? y : x;
//    Set<State> nodes = new HashSet<>();
//    nodes.add(new State(0 , 0 ));
//    Deque<State> stateDeque = new ArrayDeque<>();
//    stateDeque.add(new State(0 , 0 ));
//    while (!stateDeque.isEmpty()){
//      State state = stateDeque.poll();
//      if(state.x == z || state.y == z || state.x + state.y == z){
//        return true;
//      }
//      nodes.add(state);
//      for(State s : state.nextStateList()){
//        if(!nodes.contains(s)){
//          System.out.println(s.x + "|" + s.y);
//          stateDeque.add(s);
//        }
//      }
//    }
//    return false;
  }

  public int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
}
