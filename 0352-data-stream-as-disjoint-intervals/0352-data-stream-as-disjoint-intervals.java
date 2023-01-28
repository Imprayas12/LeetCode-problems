class SummaryRanges {
    private Set<Integer> vals;
    public SummaryRanges() {
        vals = new TreeSet<>();
    }
    
    public void addNum(int value) {
        vals.add(value);
    }
    
    public int[][] getIntervals() {
        if(vals.isEmpty()) {
            return new int[0][2];
        }
        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        for(Integer val: vals) {
            if(left < 0) {
                left = right = val;
            }
            else if(val == right + 1) right = val;
            else {
                intervals.add(new int[]{left, right});
                left = right = val;
            }
        }
        intervals.add(new int[]{left,right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */