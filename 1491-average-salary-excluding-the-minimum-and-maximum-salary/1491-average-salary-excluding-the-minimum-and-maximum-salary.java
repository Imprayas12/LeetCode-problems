class Solution {
    public double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i: salary) {
            sum += i;
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        sum -= (double)(min + max);
        return sum / (salary.length - 2);
    }
}