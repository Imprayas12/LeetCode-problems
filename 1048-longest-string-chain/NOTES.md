Approach is dynamic programming. 

Pre - Requisite is Longest Increasing Subsequence.

Initialize the dp array with value 1. as for every index the starting possible increasing subsequence's length is 1. 
Traverse the array. For every j'th index check from 0 -> j-1 if the characters before the current index make up a predecessor of current word or not. 
If the predecessor is found and difference of length is exactly 1 b/w the current index's word and predecessor. We update dp[i]'s value.

Return max[dp] for the answer.
