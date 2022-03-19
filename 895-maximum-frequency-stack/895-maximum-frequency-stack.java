class FreqStack {
    Map<Integer,Integer> mp;
    Map<Integer, Stack<Integer>> mp2;
    int frq;
    public FreqStack() {
        mp = new HashMap();
        mp2 = new HashMap();
        frq = 0;
    }
    
    public void push(int val) {
        int temp = mp.getOrDefault(val,0) + 1;
        mp.put(val,temp);
        if(temp > frq)
            frq = temp;
        mp2.computeIfAbsent(temp, z -> new Stack()).push(val);
    }
    
    public int pop() {
        int x = mp2.get(frq).pop();
        mp.put(x,mp.get(x)-1);
        if(mp2.get(frq).size()==0)
            frq--;
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */