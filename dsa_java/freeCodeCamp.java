import java.util.Arrays;

public class freeCodeCamp() {

    public static int linearSearch(int[] arr, int target) {

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target)
            return i;
    }
    return -1;
}

    public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high-low)/2;

        if (arr[mid] == target) 
            return mid;
        else if (arr[mid] < target) 
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}


    public static void main(String[] args) {
        
        int arr[] = [9,8,6,3,5,1,2,7,4];
        
        System.out.println("binarySearch: " + binarySearch(arr[], 2));
        System.out.println("linearSearch: " + linearSearch(arr[], 2));
    }
}
