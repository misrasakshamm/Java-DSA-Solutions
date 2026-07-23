/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        
        ArrayList<Integer> result = new ArrayList<>();
        // Start the recursive traversal
        traverse(root, result);
        return result;
    }
    
    private void traverse(Node node, ArrayList<Integer> result) {
        // Base case: if the node is null, we return
        if (node == null) {
            return;
        }
        
        // 1. Visit the root node
        result.add(node.data);
        
        // 2. Recursively visit the left subtree
        traverse(node.left, result);
        
        // 3. Recursively visit the right subtree
        traverse(node.right, result);
    }
}