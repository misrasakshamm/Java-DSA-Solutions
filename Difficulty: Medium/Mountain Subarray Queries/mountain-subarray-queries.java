class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        // code here
        


        int n = arr.length;
        
        // dec[i] stores the rightmost index reachable from i while moving non-decreasingly
        int[] dec = new int[n];
        // inc[i] stores the leftmost index reachable from i while moving non-increasingly
        int[] inc = new int[n];

        // 1. Fill dec array (from right to left)
        dec[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                dec[i] = dec[i + 1];
            } else {
                dec[i] = i;
            }
        }

        // 2. Fill inc array (from left to right)
        inc[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                inc[i] = inc[i - 1];
            } else {
                inc[i] = i;
            }
        }

        ArrayList<Boolean> result = new ArrayList<>();
        
        // 3. Process queries in O(1) time
        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];
            
            // Subarray forms a mountain if the non-decreasing peak from L 
            // meets or crosses the non-increasing peak ending at R
            if (dec[L] >= inc[R]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}

    