class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] dp1 = new int[n];
        dp1[0] = height[0];
        for(int i=1;i<n;i++){
            dp1[i]=Math.max(dp1[i-1],height[i]);
        }
        int[] dp2 = new int[n];
        dp2[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            dp2[i]=Math.max(dp2[i+1],height[i]);
        }
        int ans =0;
        for(int i=0;i<n;i++){
            ans+=Math.min(dp1[i],dp2[i])-height[i];
        }
        return ans;
    }
}