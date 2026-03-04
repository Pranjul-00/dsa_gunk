import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSums {

    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 15, 11, 2, 7 };
        int target = 9;

        System.out.println("Target: " + target);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("---------------------------");

        int[] optimalResult = twoSums(nums, target);
        System.out.println("Optimal Result indices: " + Arrays.toString(optimalResult));

    }
}
