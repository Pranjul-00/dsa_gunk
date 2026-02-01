#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {

    if (nums1.size() > nums2.size()) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.size();
    int n = nums2.size();
    int low = 0;
    int high = m;

    while (low <= high) {
      int partition1 = (low + high) / 2;
      int partition2 = ((m + n + 1) / 2) - partition1;

      int l1 = (partition1 == 0) ? INT_MIN : nums1[partition1 - 1];
      int r1 = (partition1 == m) ? INT_MAX : nums1[partition1];

      int l2 = (partition2 == 0) ? INT_MIN : nums2[partition2 - 1];
      int r2 = (partition2 == n) ? INT_MAX : nums2[partition2];

      if (l1 <= r2 && l2 <= r1) {
        if ((m + n) % 2 != 0) {
          return max(l1, l2);
        } else {
          return (max(l1, l2) + min(r1, r2)) / 2.0;
        }
      } else if (l1 > r2) {
        high = partition1 - 1;
      } else {
        low = partition1 + 1;
      }
    }
    return 0.0;
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {1, 3};
  vector<int> nums2 = {2};

  cout << sol.findMedianSortedArrays(nums1, nums2) << endl;

  return 0;
}