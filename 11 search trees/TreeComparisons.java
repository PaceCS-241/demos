import java.util.Hashtable;

public class TreeComparisons {
    public static void main(String[] args) {
        BinarySearchTree<Integer> sampleBST = new BinarySearchTree<>();
        sampleBST.insert(3);
        sampleBST.insert(1);
        sampleBST.insert(4);
        
        // time a search in nanoseconds
        long startTime = System.nanoTime();
        sampleBST.contains(2);
        long endTime = System.nanoTime();
        long runTime = (endTime - startTime);
        System.out.printf("Runtime: %d ns\n", runTime);
    }

    public static BinarySearchTree<Integer> buildSkewedBST(int n) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        // inserts


        return bst;
    }

    /* 
     * Seq method. Pre-order traversal algorithm for inserting a range
     * seq(low, high, T){
            if (low <= high){
                mid = (low+high)/2
                T.insert(mid)
                seq(low, mid-1, T)
                seq(mid+1, high, T)
            }
        }
     */
}
