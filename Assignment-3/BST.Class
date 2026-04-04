public class BST<K extends Comparable<K>, V> {

    private class BSTNode { // Inner class for tree nodes
        K key;
        V value;
        BSTNode left;
        BSTNode right;

        public BSTNode(K key, V value) { // Constructor
            this.key = key; // Initialize
            this.value = value;
            left = null;
            right = null;
        }
    }

    private BSTNode root; 

    public BST() {
        root = null;
    }

    //Instructor used T, but changed to K and V to match main method
    // Insert a key-value pair into the BST
    public void insert(K key, V value) {
        BSTNode newNode = new BSTNode(key, value); // Create new node to insert

        if (root == null) { // If tree is empty, set new node as root
            root = newNode;
        } else {
            insert(root, newNode);
        }
    }
    
    private void insert(BSTNode current, BSTNode newNode) {
        if (newNode.key.compareTo(current.key) < 0) { // If new key is smaller, go left
            if (current.left == null) {
                current.left = newNode;
            } else {
                insert(current.left, newNode);
            }
        } else { // If new key is larger or equal, go right
            if (current.right == null) {
                current.right = newNode;
            } else {
                insert(current.right, newNode);
            }
        }
    }

    // Search for a value by key in the BST
    public V search(K key) {
        return search(root, key);
    }

    private V search(BSTNode current, K key) {
        if (current == null) {
            return null;
        }
        if (current.key.equals(key)) { // If key matches, return value
            return current.value;
        }
        if (key.compareTo(current.key) < 0) { // If key is smaller, search left
            return search(current.left, key);
        } else {                              // If key is larger, search right
            return search(current.right, key);
        }
    }

    public boolean delete(K key) {
        if (search(key) == null) { // If key doesn't exist, return false
            return false;
        }

        root = delete(root, key); // Delete the node and update root
        return true;
    }

    private BSTNode delete(BSTNode current, K key) {
        if (current == null) { 
            return null;
        }

        if (key.compareTo(current.key) < 0) {
            current.left = delete(current.left, key);
        } else if (key.compareTo(current.key) > 0) { 
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            BSTNode temp = findMin(current.right);
            current.key = temp.key;
            current.value = temp.value;
            current.right = delete(current.right, temp.key);
        }

        return current;
    }

    private BSTNode findMin(BSTNode current) {
        if (current == null) { // If tree is empty, return null
            return null;
        }

        while (current.left != null) {
            current = current.left;
        }

        return current; // Return the node with the minimum key
    }

    public void deleteAll() { // Clear the entire tree
        root = null; 
    }

    public void displayTree() { // Display the tree structure
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            displayTree(root, 0);
        }
    }

    private void displayTree(BSTNode current, int level) { 
        if (current != null) { // If current node is not null, display right subtree first
            displayTree(current.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("||==> " + current.key + ":" + current.value);

            displayTree(current.left, level + 1);
        }
    }

    public void inOrderTraversal() { // In-order traversal: left, root, right
        inOrderTraversal(root); 
    }

    private void inOrderTraversal(BSTNode current) {
        if (current != null) {
            inOrderTraversal(current.left);
            System.out.println(current.key + ":" + current.value);
            inOrderTraversal(current.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BSTNode current) {
        if (current != null) {
            System.out.println(current.key + ":" + current.value);
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BSTNode current) {
        if (current != null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.println(current.key + ":" + current.value);
        }
    }
}
