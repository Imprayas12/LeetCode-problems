**Recursive (TLE)**
​
```
class Solution {
public int minimumTotal(List<List<Integer>> triangle) {
return minPath(triangle,0,0);
}
private int minPath(List<List<Integer>> arr,int i,int j){
if(i==arr.size()-1) return arr.get(i).get(j);
int down = arr.get(i).get(j) + minPath(arr,i+1,j);
int down_right = arr.get(i).get(j) + minPath(arr,i+1,j+1);
return Math.min(down,down_right);
}
}
```