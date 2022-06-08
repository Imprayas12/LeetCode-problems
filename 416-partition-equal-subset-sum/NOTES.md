**Memoized (Accepted)**
```
class Solution {
public boolean canPartition(int[] nums) {
int n =nums.length;
int sum=0;
for(var i:nums) sum+=i;
if(sum%2==1) return false;
int[][] dp = new int[n][sum/2+1];
for(var i: dp){
Arrays.fill(i,-1);
}
return f(nums,n-1,sum/2,dp);
}
private boolean f(int[] nums,int index,int target,int[][] dp){
if(target==0)
return true;
if(index==0)
return nums[0]==target;
if(dp[index][target]!=-1) return dp[index][target]==1?true:false;
boolean notTake = f(nums,index-1,target,dp);
boolean take = false;
if(nums[index]<=target) take = f(nums,index-1,target-nums[index],dp);
dp[index][target]=take||notTake?1:0;
return  take||notTake;
}
}
​
```