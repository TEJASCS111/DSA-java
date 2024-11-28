public class SubsetSum {
    static boolean isSubsetSum(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) 
            for (int i = sum; i >= num; i--) 
                dp[i] |= dp[i - num];
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(nums, sum));
    }
}
