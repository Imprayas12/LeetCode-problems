return grid[0][0];
int n = grid.length;
int[][] dp = new int[n][n];
return minPath(grid,dp);
}
private int minPath(int[][] arr,int[][] dp){
for(int i=0;i<arr.length;i++){
dp[arr.length-1][i] = arr[arr.length-1][i];
}
int n = arr.length;
for(int i=n-2;i>=0;i--){
for(int j=0;j<n;j++){
int ans = Integer.MAX_VALUE;
for(int k=0;k<n;k++){
if(k!=j){
ans = Math.min(ans,arr[i][j]+dp[i+1][k]);
}
}
dp[i][j] = ans;
}
}
int ans = Integer.MAX_VALUE;
for(int i=0;i<n;i++){
ans = Math.min(ans,dp[0][i]);
}
return ans;
}
}
```
​