package binaryexpressiontree;

public class ExpressionTree {
    public static void main(String[] args) {
        BinaryTree<String> expression = buildSampleTree();
        System.out.println(expression.toString());
        
    }

    /** create a binary tree for the following expression
     *  x / y  + 3 * b / c
     * @return BinaryTree<String> final tree
     */
    
     public static BinaryTree<String> buildSampleTree() {
        // leaves (operands)
        BinaryTree<String> x = new BinaryTree<>("x", null, null);
        BinaryTree<String> y = new BinaryTree<>("y", null, null);
        BinaryTree<String> three = new BinaryTree<>("3", null, null);
        BinaryTree<String> b = new BinaryTree<>("b", null, null);
        BinaryTree<String> c = new BinaryTree<>("c", null, null);
        // internal nodes (operators)
        BinaryTree<String> dividexy = new BinaryTree<>("/", x, y);
        BinaryTree<String> dividebc = new BinaryTree<>("/", b, c);
        BinaryTree<String> multiply = new BinaryTree<>("*", three, dividebc);
        // root
        BinaryTree<String> plus = new BinaryTree<>("+", dividexy, multiply);
        return plus;
    }

}