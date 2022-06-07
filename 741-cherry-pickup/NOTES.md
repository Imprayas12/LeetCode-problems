**Recursion**
​
```
class Solution {
public int cherryPickup(int[][] grid) {
return cherryCount(grid,0,0,0,grid.length);
}
private int cherryCount(int[][] grid,int i,int j1,int j2,int n){
int i2 = i + j1-j2;
if(i==n || i2==n || grid[i2][j2]==-1 || j1==n || j2==n ||   grid[i][j1]==-1) return -999999;
if(i==n-1 && j1==n-1) return grid[i][j1];
int ans = grid[i][j1];
if(j1!=j2) ans+= grid[i2][j2];
ans += Math.max(Math.max(cherryCount(grid,i,j1+1,j2+1,n),cherryCount(grid,i+1,j1,j2+1,n)), Math.max(cherryCount(grid,i,j1+1,j2,n),cherryCount(grid,i+1,j1,j2,n)));
return ans;
}
}
```
​
​