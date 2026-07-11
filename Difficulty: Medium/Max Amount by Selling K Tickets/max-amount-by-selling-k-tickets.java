class Solution {
    public int maxAmount(int[] arr, int k) {
        // code here
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        long maxAmount = 0;
        long mod = 1000000007;
        
        int n = arr.length;
        int i = n - 1; // Start from the seller with the most tickets
        
        while (k > 0 && i >= 0) {
            // Find the number of tickets the next seller has (0 if no seller left)
            int nextValue = (i > 0) ? arr[i - 1] : 0;
            int ticketsToSell = arr[i] - nextValue;
            
            // Number of sellers sharing the current maximum ticket count
            int count = n - i;
            
            // Case 1: We can sell down to the next value for all 'count' sellers
            if ((long) ticketsToSell * count <= k) {
                // Sum of arithmetic progression: (curr_price + ... + (next_price + 1))
                long sum = (long) count * ((long) (arr[i] + nextValue + 1) * (arr[i] - nextValue) / 2) % mod;
                maxAmount = (maxAmount + sum) % mod;
                k -= ticketsToSell * count;
            } 
            // Case 2: We cannot reach the next level completely with the remaining k
            else {
                int fullSells = k / count;
                int remainder = k % count;
                
                // Add the complete rows we can sell
                if (fullSells > 0) {
                    long sum = (long) count * ((long) (arr[i] + (arr[i] - fullSells + 1)) * fullSells / 2) % mod;
                    maxAmount = (maxAmount + sum) % mod;
                }
                
                // Add the partial row for the remainder tickets
                if (remainder > 0) {
                    long remainderSum = (long) remainder * (arr[i] - fullSells) % mod;
                    maxAmount = (maxAmount + remainderSum) % mod;
                }
                
                k = 0; // All tickets allocated
            }
            
            i--; // Move to include the next seller
        }
        
        return (int) (maxAmount % mod);
    }
}

    