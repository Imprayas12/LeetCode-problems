**Iterative DFS (RECURSIVE APPROACH) TLE**
​
```
class Solution {
public int minFallingPathSum(int[][] matrix) {
int ans = Integer.MAX_VALUE;
for(int i=0;i<matrix.length;i++){
ans = Math.min(ans,minPath(0,i,matrix));
}
return ans;
}
private int minPath(int i,int j,int[][] arr){
if(i==arr.length-1)
return arr[i][j];
int left = Integer.MAX_VALUE;
int bottom = Integer.MAX_VALUE;
int right = Integer.MAX_VALUE;
if(j>0) left = arr[i][j]+ minPath(i+1,j-1,arr);
bottom = arr[i][j] + minPath(i+1,j,arr);
if(j<arr.length-1) right = arr[i][j] + minPath(i+1,j+1,arr);
return Math.min(right,Math.min(left,bottom));
}
}
```
​
​