#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isValidParentheses(string s) {

  stack<char> st;

  for (char c : s) {

    if (c == '(' || c == '[' || c == '{') {
      st.push(c);
    } else {
      if (st.empty()) {
        return false;
      }

      char topBracket = st.top();

      if ((c == ')' && topBracket == '(') || (c == ']' && topBracket == '[') ||
          (c == '}' && topBracket == '{')) {
        st.pop();
      }

      else {
        return false;
      }
    }
  }

  return st.empty();
}

int main() {

  string test1 = "({[]})";
  string test2 = "({[})";

  cout << "Test 1 " << test1 << ": " << (isValidParentheses(test1))
      ? "Valid"
      : "Invalid" << endl;
  cout << "Test 2 " << test2 << ": " << (isValidParentheses(test2))
      ? "Valid"
      : "Invalid" << endl;

  return 0;
}
