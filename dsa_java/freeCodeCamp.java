import java.util.Arrays;
import java.util.Scanner;

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

    // Printing triplets O(n^3)
    public static int printTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    count++;
                }
            }
        }
        return count;
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = { 9, 8, 6, 3, 5, 1, 2, 7, 4 };
        boolean isRunning = true;
        int target = 2;

        while (isRunning) {
            System.out.println("\n=== DSA TOOLKIT MENU ===");
            System.out.println("Current Array: " + Arrays.toString(arr));
            System.out.println("Target Number: " + target);
            System.out.println("------------------------");
            System.out.println("1. Run Linear Search O(n)");
            System.out.println("2. Run Merge Sort O(n log n)");
            System.out.println("3. Run Binary Search O(log n) -> (Run Merge Sort first!)");
            System.out.println("4. Print All Pairs O(n^2)");
            System.out.println("5. Print All Triplets O(n^3)");
            System.out.println("6. Fibonacci Series");
            System.out.println("0. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("Linear Search index result: " + linearSearch(arr, target));
                    break;
                case 2:
                    System.out.println("Sorting array...");
                    mergeSort(arr, 0, arr.length - 1);
                    System.out.println("Array sorted successfully!");
                    break;
                case 3:
                    System.out.println("Binary Search index result: " + binarySearch(arr, target));
                    break;
                case 4:
                    int pairCount = printPairs(arr);
                    System.out.println("Total pairs printed: " + pairCount);
                    break;
                case 5:
                    int tripletCount = printTriplets(arr);
                    System.out.println("Total triplets printed: " + tripletCount);
                    break;
                case 6:
                    System.out.print("Enter a number: ");
                    int n = scanner.nextInt();
                    fibonacci(n);

                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 0 to 5.");
            }
        }

        scanner.close();
    }
}
