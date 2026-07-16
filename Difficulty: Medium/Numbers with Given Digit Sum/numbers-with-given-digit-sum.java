class Solution {
    public int countWays(int n, int sum) {
        // code here
      
        // Base edge case: An n-digit number can have a maximum sum of 9 * n
        // It also cannot have a sum less than 1 (as leading zero is not allowed)
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        // dp[i][j] stores the number of valid sequences of length 'i' that sum up to 'j'
        int[][] dp = new int[n + 1][sum + 1];
        
        // Initialize the table with -1 to represent uncalculated states
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int totalWays = 0;

        // Enforce the rule: The first digit cannot be 0, so loop from 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (sum - digit >= 0) {
                totalWays += helper(n - 1, sum - digit, dp);
            }
        }

        // If total ways is 0, it means no such number exists, return -1
        return totalWays == 0 ? -1 : totalWays;
    }

    private int helper(int digitsLeft, int currentSum, int[][] dp) {
        // Base case: If no digits are left, check if we successfully reduced the sum to 0
        if (digitsLeft == 0) {
            return currentSum == 0 ? 1 : 0;
        }

        // Base case: If the required sum becomes negative, this path is invalid
        if (currentSum < 0) {
            return 0;
        }

        // Return the cached result if it has already been computed
        if (dp[digitsLeft][currentSum] != -1) {
            return dp[digitsLeft][currentSum];
        }

        int ways = 0;

        // For all subsequent digits, they can range anywhere from 0 to 9
        for (int digit = 0; digit <= 9; digit++) {
            if (currentSum - digit >= 0) {
                ways += helper(digitsLeft - 1, currentSum - digit, dp);
            }
        }

        // Store the result in the dp table and return
        return dp[digitsLeft][currentSum] = ways;
    

    }
};