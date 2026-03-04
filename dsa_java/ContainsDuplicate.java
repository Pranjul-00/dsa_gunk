import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrayWithDupes = { 1, 2, 3, 1 };
        int[] arrayWithoutDupes = { 1, 2, 3, 4 };

        System.out.println("]\nArray 1: " + Arrays.toString(arrayWithDupes));
        System.out.println("Contains Duplicate? : " + containsDuplicate(arrayWithDupes));

        System.out.println("\nArray 2: " + Arrays.toString(arrayWithoutDupes));
        System.out.println("Contains Duplicate? : " + containsDuplicate(arrayWithoutDupes));
        System.out.println();
    }
}
