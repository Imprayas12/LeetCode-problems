class Solution(object):
    def buddyStrings(self, s, goal):
        if len(s) != len(goal):
            return False
        
        if s == goal:
            frequency = [0] * 26
            for ch in s:
                frequency[ord(ch) - ord('a')] += 1
                if frequency[ord(ch) - ord('a')] == 2:
                    return True
            return False
        
        n = len(s)
        indices = []
        for i in range(n):
            if s[i] != goal[i]:
                indices.append(i)
        
        if len(indices) != 2:
            return False
        
        idx1, idx2 = indices[0], indices[1]
        return s[idx1] == goal[idx2] and s[idx2] == goal[idx1]
