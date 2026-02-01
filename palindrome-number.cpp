#include <iostream>

using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {

        if ((x % 10 == 0 && x != 0) || x < 0){
            return false;
        }

        long long int revNum = 0;

        while (x > revNum){
            revNum = (revNum*10) + x%10;
            x /= 10;
        }

        if (x == revNum || x == revNum/10){
            return true;
        }
        return false;
    }
};

int main() {
    Solution sol;
    
    // Test cases
    int test1 = 121;
    int test2 = -121;
    int test3 = 10;

    cout << "Is " << test1 << " a palindrome? " << (sol.isPalindrome(test1) ? "true" : "false") << endl;
    cout << "Is " << test2 << " a palindrome? " << (sol.isPalindrome(test2) ? "true" : "false") << endl;
    cout << "Is " << test3 << " a palindrome? " << (sol.isPalindrome(test3) ? "true" : "false") << endl;

    return 0;
}