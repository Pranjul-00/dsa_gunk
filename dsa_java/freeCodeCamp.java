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

    // MergeSort: Conquer O(n)
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Printing pairs O(n^2)
    public static int printPairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = { 9, 8, 6, 3, 5, 1, 2, 7, 4 };

        System.out.println("\nArray being used: " + Arrays.toString(arr));
        System.out.println("Target: 2");
        System.out.println();

        System.out.println("Linear Search (unsorted): " + linearSearch(arr, 2));

        System.out.println("\n--- Starting Merge Sort ---");
        System.out.println("Array before: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Array after: " + Arrays.toString(arr));
        System.out.println("---------------------\n");

        System.out.println("binarySearch: " + binarySearch(arr, 2) + "\n");

        System.out.println("There were " + count + " for the array, they are given below\n");
        printPairs(arr);
        System.out.println();
    }
}
