#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substr(start, end - start + 1);
    }

private:
    int expandAroundCenter(const string& s, int left, int right) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
};

int main() {
    Solution sol;
    
    string s1 = "babad";
    string result1 = sol.longestPalindrome(s1);
    cout << "Input: " << s1 << "\nOutput: " << result1 << endl;

    cout << "-----------------" << endl;

    string s2 = "cbbd";
    string result2 = sol.longestPalindrome(s2);
    cout << "Input: " << s2 << "\nOutput: " << result2 << endl;

    return 0;
}