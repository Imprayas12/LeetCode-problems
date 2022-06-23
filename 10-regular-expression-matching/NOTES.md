Recursive Approach:

If the current element either matches with the pattern's current character or the pattern's current character is '-'. Then just move the pointer forward and recursively call the function. Else if the pattern's character is * then make two recursive calls, one which ignores the element and one which takes the element into account.

If T is the length of string and P is the length of pattern. then

TC - O((T+P)2^(T+P/2))

SC - O(T^2 + P^2)

Memoization:
Memoize the recursive solution with the string's index and pattern's index because overlapping subproblems will be there to begin with.

TC - O(T * P)

SC - O(T * P)
