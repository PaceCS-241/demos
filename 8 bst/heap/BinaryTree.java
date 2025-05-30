package heap;

/** Class for a binary tree that stores type E objects */
public class BinaryTree<E> {
    /** Class to encapsule a tree node */
    protected static class Node<E> {
        // Data Fields
        /** The information stored in this node */
        protected E data;
        /** Reference to the left child */
        protected Node<E> left;
        /** Reference to the right child */
        protected Node<E> right;

        // Constructors
        /** Construct a node with given data and no children
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        // Methods
        /** Return a string representation of the node
         * @return a string representation of the data
         */
        public String toString() {
            return data.toString();
        }
    }

    // Data Field
    /** The root of the binary tree */
    protected Node<E> root;

    // Constructors
    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root leftTree
     * as its left subtree and rightTree as its right subtree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if(leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if(rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /** Return the left subtree 
     * @return the left subtree or null if either the root or 
     *         the left subtree is null
    */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /** Return the right subtree 
     * @return the right subtree or null if either the root or 
     *         the right subtree is null
    */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    /** Determine whether this tree is a leaf
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }
    /** Return a string representation of the node
     * @return a string representation of the data
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }

    /** Converts a subtree to a string
     * Performs a preorder traversal
     * @param node the local root
     * @param depth the depth
     * @param db the StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth, StringBuilder sb) {
        if(node != null) {
            for(int i=1; i<depth; i++) {
                sb.append(" ");
            }
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth+1, sb);
            toString(node.right, depth+1, sb);
        }
    }
}