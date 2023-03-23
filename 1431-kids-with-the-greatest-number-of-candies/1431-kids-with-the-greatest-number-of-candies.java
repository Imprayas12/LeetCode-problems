class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> list = new ArrayList<>();
        for(int i: candies) {
            if(i + extraCandies >= max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}