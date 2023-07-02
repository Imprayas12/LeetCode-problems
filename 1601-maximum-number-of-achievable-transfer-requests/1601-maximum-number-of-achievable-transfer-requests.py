class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        self.answer = 0
        in_degree = [0] * n
        self.helper(0, 0, in_degree, requests)
        return self.answer
    
    def helper(self, index, count, in_degree, requests):
        if index == len(requests):
            for i in in_degree:
                if i != 0:
                    return
            self.answer = max(self.answer, count)
            return

        in_degree[requests[index][0]] += 1
        in_degree[requests[index][1]] -= 1
        self.helper(index + 1, count + 1, in_degree, requests)
        in_degree[requests[index][0]] -= 1
        in_degree[requests[index][1]] += 1
        self.helper(index + 1, count, in_degree, requests)