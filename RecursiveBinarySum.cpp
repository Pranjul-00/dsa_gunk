#include <iostream>

long long binarySum(int arr[], int low, int high) {
  if (low == high) {
    return arr[low];
  }

  int mid = low + (high - low) / 2;

  return binarySum(arr, low, mid) + binarySum(arr, mid + 1, high);
}

int main() {
  int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8};
  int n = sizeof(numbers) / sizeof(numbers[0]);

  long long total = binarySum(numbers, 0, n - 1);

  std::cout << "Sum: " << total << std::endl;

  return 0;
}