class Solution {
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
    
        // code here
        int n = arr.length;
        int totalLen = 0;
        for (String s : arr) totalLen += s.length();
        
        // Trie using arrays; 0 = no child, root = node 1
        int[][] children = new int[totalLen + 2][26];
        int[] freq = new int[totalLen + 2];
        int nodeCount = 2; // node 1 is root, next free node id
        
        // Insert all words into trie
        for (String word : arr) {
            int curr = 1;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int idx = word.charAt(i) - 'a';
                if (children[curr][idx] == 0) {
                    children[curr][idx] = nodeCount++;
                }
                curr = children[curr][idx];
                freq[curr]++;
            }
        }
        
        // Find shortest unique prefix for each word
        ArrayList<String> result = new ArrayList<>(n);
        for (String word : arr) {
            int curr = 1;
            int len = word.length();
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                prefix.append(ch);
                curr = children[curr][idx];
                if (freq[curr] == 1) {
                    break;
                }
            }
            result.add(prefix.toString());
        }
        
        return result;
    }
}
    