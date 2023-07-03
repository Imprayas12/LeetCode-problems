class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if(s.length() != goal.length()) return false;
        if(s == goal) {
            vector<int> frequency(26, 0);
            for(char ch : s) {
                frequency[ch - 'a'] += 1;
                if(frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        int n = s.length();
        vector<int> indices;
        for(int i = 0; i < n; i++) {
            if(s[i] != goal[i]) {
                indices.push_back(i);
            }
        }
        if(indices.size() != 2) return false;
        int idx1 = indices[0];
        int idx2 = indices[1];
        return s[idx1] == goal[idx2] && s[idx2] == goal[idx1];
    }
};