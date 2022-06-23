Naive Approach:

Nested loops to iterate through the array and add up the pairs to check if they result in target sum.
TC - O(n^2)
SC - O(1)

Better Approach:

Sort the array first. Keep Two pointers, iterate from front and back. Check if arr[front] + arr[end] == target. 

TC - O(nlogn)
SC - O(1)

Best Approach:

Keep a hashmap. For every new value, check if the complement already exists in the map as key. If yes then return the current index and mapped index else put the current value with index in hashmap.

TC - O(n)
SC - O(n)
