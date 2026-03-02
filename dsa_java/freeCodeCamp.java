import java.util.Arrays;

public class freeCodeCamp {

    // Linear Search O(n)
    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search O(logn)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // MergeSort: Divide O(logn)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        int arr[] = { 9, 8, 6, 3, 5, 1, 2, 7, 4 };
        System.out.println("linearSearch: " + linearSearch(arr, 2));

        Arrays.sort(arr);
        System.out.println("binarySearch: " + binarySearch(arr, 2));
    }
}
