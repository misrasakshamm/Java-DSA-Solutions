class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
    
        int n = arr.length;
        if (n < 2) return 0;

        // Arrays to store maximum and minimum subarray sums from the left
        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        
        // Arrays to store maximum and minimum subarray sums from the right
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        // 1. Traverse left-to-right to fill leftMax and leftMin
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        leftMax[0] = arr[0];
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], maxEndingHere);

            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            leftMin[i] = Math.min(leftMin[i - 1], minEndingHere);
        }

        // 2. Traverse right-to-left to fill rightMax and rightMin
        maxEndingHere = arr[n - 1];
        minEndingHere = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            rightMax[i] = Math.max(rightMax[i + 1], maxEndingHere);

            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            rightMin[i] = Math.min(rightMin[i + 1], minEndingHere);
        }

        // 3. Evaluate all valid splitting boundaries to maximize absolute difference
        int maxAbsDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            // Case A: Left Subarray has Max Sum, Right Subarray has Min Sum
            int absDiff1 = Math.abs(leftMax[i] - rightMin[i + 1]);
            
            // Case B: Left Subarray has Min Sum, Right Subarray has Max Sum
            int absDiff2 = Math.abs(leftMin[i] - rightMax[i + 1]);
            
            maxAbsDiff = Math.max(maxAbsDiff, Math.max(absDiff1, absDiff2));
        }

        return maxAbsDiff;
    }
}
    