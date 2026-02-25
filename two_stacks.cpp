#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int twoStacks(int maxSum, vector<int> a, vector<int> b) {
  long long current_sum = 0;
  int count_a = 0;
  int max_score = 0;

  while (count_a < a.size() && current_sum + a[count_a] <= maxSum) {
    current_sum += a[count_a];
    count_a++;
  }

  max_score = count_a;

  int count_b = 0;
  while (count_b < b.size()) {
    current_sum += b[count_b];
    count_b++;

    while (current_sum > maxSum && count_a > 0) {
      count_a--;
      current_sum -= a[count_a];
    }

    if (current_sum > maxSum) {
      break;
    }

    max_score = max(max_score, count_a + count_b);
  }

  return max_score;
}

int main() {
  int maxSum = 10;
  vector<int> a = {4, 2, 4, 6, 1};
  vector<int> b = {2, 1, 8, 5};

  cout << "Maximum score: " << twoStacks(maxSum, a, b) << endl;

  return 0;
}
