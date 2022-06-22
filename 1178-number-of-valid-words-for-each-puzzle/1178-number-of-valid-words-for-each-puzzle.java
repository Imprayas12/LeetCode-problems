class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer,Integer> map = new HashMap();
     for(var wd: words){
         int mask = bitmask(wd);
         map.put(mask,map.getOrDefault(mask,0)+1);
        }
        List<Integer> res = new ArrayList();
        for(var puz: puzzles){
            int f = 1<<(puz.charAt(0)-'a');
            int c = map.getOrDefault(f,0);
            int mask = bitmask(puz.substring(1));
            for(int submask = mask; submask>0;submask = (submask-1) & mask){
                c+= map.getOrDefault(submask | f, 0);
            }
            res.add(c);
        }
        return res;
    }
    private int bitmask(String word){
        int mask = 0;
        for(var ch: word.toCharArray())
            mask = mask | 1<<(ch-'a');
        return mask;
    }
}