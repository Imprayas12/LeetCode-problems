**Recursion (TLE)**
​
```
class Solution {
public int cherryPickup(int[][] grid) {
int di[] = {-1,0,1};
int[] dj = {-1,0,1};
return maxCherry(0,0,grid[0].length-1,grid,di,dj);
}
private int maxCherry(int i,int j1,int j2,int[][] grid,int[] di,int[] dj){
if(j1<0 || j1>grid[0].length-1 || j2<0 || j2>grid[0].length-1)
return 0;
if(i==grid.length-1){
if(j1==j2)
return grid[i][j1];
else{
return grid[i][j1]+grid[i][j2];
}
}
int ans = 0;
for(var k: di){
for(var l: dj){
if(j1==j2)
ans = Math.max(ans,grid[i][j1]+maxCherry(i+1,j1+k,j2+l,grid,di,dj));
else ans = Math.max(ans,grid[i][j1]+grid[i][j2] +maxCherry(i+1,j1+k,j2+l,grid,di,dj));
}
}
return ans;
}
}
```