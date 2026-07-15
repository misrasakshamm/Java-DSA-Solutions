class Solution {
    public int bitonic(int[] arr) {
        // code here
   
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int n = arr.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        
        // Base values: a single element is always bitonic of length 1
        inc[0] = 1;
        dec[n - 1] = 1;
        
        // Step 1: Calculate longest increasing subarray ending at each index
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        
        // Step 2: Calculate longest decreasing subarray starting at each index
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }
        
        // Step 3: Find the maximum length by combining both paths
        int maxBitonicLength = 0;
        for (int i = 0; i < n; i++) {
            // Subtract 1 because the peak element 'i' is counted in both arrays
            int currentLength = inc[i] + dec[i] - 1;
            if (currentLength > maxBitonicLength) {
                maxBitonicLength = currentLength;
            }
        }
        
        return maxBitonicLength;
    }
}
   