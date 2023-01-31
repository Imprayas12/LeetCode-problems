class Solution {
    class Pair {
        int age;
        int score;
        Pair(int age,int score) {
            this.age = age;
            this.score = score;
        }
        @Override
        public String toString() {
            return String.valueOf(this.age + " " + this.score);
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Pair> list = new ArrayList<>();
        int n = ages.length;
        for(int i = 0; i < n; i++) {
            list.add(new Pair(ages[i],scores[i]));
        }
        Collections.sort(list,(a,b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        Integer[][] dp = new Integer[n][n];
        return findMax(list,dp,0,-1);
    }
    private int findMax(List<Pair> list,Integer[][] dp,int idx,int prev) {
        if(idx >= list.size()) return 0;
        if(dp[prev + 1][idx] != null) return dp[prev + 1][idx];
        if(prev == -1 || list.get(prev).score <= list.get(idx).score) {
            return dp[prev + 1][idx] = Math.max(findMax(list,dp,idx + 1,prev),list.get(idx).score + findMax(list,dp,idx + 1,idx));
        }
        return dp[prev + 1][idx] = findMax(list,dp,idx + 1,prev);
    }
}