Given the definition, the problem can also be interpreted as finding the power set from a sequence.
​
So, this time let us loop over the length of combination, rather than the candidate numbers, and generate all combinations for a given length with the help of backtracking technique.
**Algorithm**
​
We define a backtrack function named backtrack(first, curr) which takes the index of first element to add and a current combination as arguments.
​
* If the current combination is done, we add the combination to the final output.
​
* Otherwise, we iterate over the indexes i from first to the length of the entire sequence n.
​
*     Add integer nums[i] into the current combination curr.
​
*       Proceed to add more integers into the combination : backtrack(i + 1, curr).
​
*         Backtrack by removing nums[i] from curr.
​