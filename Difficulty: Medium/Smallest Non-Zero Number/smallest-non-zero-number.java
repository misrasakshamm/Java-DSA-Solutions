class Solution {
    public int find(int[] arr) {
        // code here
        // Start from the final state where the value can be at least 0
        int required = 0;
        
        // Traverse backwards from the last element to the first
        for (int i = arr.length - 1; i >= 0; i--) {
            // Equivalent to Math.ceil((required + arr[i]) / 2.0)
            required = (required + arr[i] + 1) / 2;
        }
        
        return required;
    }
}

    
