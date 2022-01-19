class Solution {
    public String intToRoman(int num) {
        int[] hehe1 = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] hehe2 = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer br = new StringBuffer("");
        for(int i=0;i<hehe1.length;i++){
            while(num>=hehe1[i]){
                num-=hehe1[i];
                br.append(hehe2[i]);
            }
        }
        return br.toString();
    }
}