#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int> &nums, int target) {

    unordered_map<int, int> diary;

    for (int i = 0; i < nums.size(); i++) {
      int current = nums[i];
      int needed = target - current;

      if (diary.find(needed) != diary.end()) {
        return {diary[needed], i};
      }
      diary[current] = i;
    }
    return {};
  }
};

int main() {
  Solution sol;
  vector<int> nums = {2, 7, 11, 15};
  int target = 9;

  vector<int> result = sol.twoSum(nums, target);

  if (result.size() == 2) {
    cout << "[" << result[0] << ", " << result[1] << "]" << endl;
  } else {
    cout << "[]" << endl;
  }

  return 0;
}