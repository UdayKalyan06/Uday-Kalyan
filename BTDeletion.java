class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Method to delete a node from the BST
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Method to insert a node into the BST using an iterative approach
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while (true) {
            if (data < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    // Recursive method to delete a node from the BST
    private TreeNode deleteRec(TreeNode root, int data) {
        if (root == null) {
            return null;
        }

        // Recursively search for the node to be deleted
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the in-order successor (minimum node in the right subtree)
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Helper method to find the minimum value in a tree
    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }
}

public class BTDeletion {
    // Helper method to create a sample BST
    public static BinarySearchTree createBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        return bst;
    }

    // Main method to run the example
    public static void main(String[] args) {
        BinarySearchTree bst = createBinarySearchTree();
        bst.delete(7);

        System.out.println("Sample Binary Search Tree with node 7 deleted:");
        bst.print(bst.root);
    }
}
