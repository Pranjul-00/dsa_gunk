#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isValidParentheses(string s) {

  stack<char> st; // make an empty stack

  // loop through string s
  for (char c : s) {

    // if it is an opening bracket, push it on the stack
    if (c == '(' || c == '[' || c == '{') {
      st.push(c);
    }

    // if it is a closing bracket, check for a opening match
    else {
      if (st.empty()) {
        return false;
      }

      // look at the top most bracket of the stack
      char topBracket = st.top();

      // check for a matching pair
      if ((c == ')' && topBracket == '(') || (c == ']' && topBracket == '[') ||
          (c == '}' && topBracket == '{')) {
        st.pop(); // if it matches then, remove the opening bracket from stack
      }

      else {
        return false; // there was a mismatch
      }
    }
  }

  return st
      .empty(); // if our stack is empty at the end, then everything matched
                // perfectly if it is not, then we have unclosed bracket left
}

int main() {

  string test1 = "({[]})";
  string test2 = "({[})";

  cout << "Test 1 " << test1 << ": "
       << ((isValidParentheses(test1)) ? "Valid" : "Invalid") << endl;
  cout << "Test 2 " << test2 << ": "
       << ((isValidParentheses(test2)) ? "Valid" : "Invalid") << endl;

  return 0;
}
