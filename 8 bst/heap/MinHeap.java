package heap;

public class MinHeap {
    /** create a sample heap
     * @return BinaryTree<String> final tree
     */
    
     public static BinaryTree<Integer> buildSampleHeap1() {
        // valid min heap
        BinaryTree<Integer> seventysix = new BinaryTree<>(76, null, null);
        BinaryTree<Integer> fiftyeight = new BinaryTree<>(58, null, null);
        BinaryTree<Integer> eightfive = new BinaryTree<>(85, null, null);
        BinaryTree<Integer> sixtyseven = new BinaryTree<>(67, null, null);
        BinaryTree<Integer> fortynine = new BinaryTree<>(49, null, null);
        BinaryTree<Integer> fortyfive = new BinaryTree<>(45, seventysix, null);
        BinaryTree<Integer> thirtynine = new BinaryTree<>(39, eightfive, fiftyeight);
        BinaryTree<Integer> thirtyseven = new BinaryTree<>(37, fortynine, sixtyseven);
        BinaryTree<Integer> twentyone = new BinaryTree<>(21, thirtynine, fortyfive);
        BinaryTree<Integer> fifteen = new BinaryTree<>(15, twentyone, thirtyseven);

        return fifteen;
    }

    public static BinaryTree<Integer> buildSampleHeap2() {
        // not valid min heap
        BinaryTree<Integer> ninetyseven = new BinaryTree<>(97, null, null);
        BinaryTree<Integer> sixtytwo = new BinaryTree<>(62, null, null);
        BinaryTree<Integer> eightyfive = new BinaryTree<>(85, null, null);
        BinaryTree<Integer> fiftyfour = new BinaryTree<>(54, null, null);
        BinaryTree<Integer> sixtyfive = new BinaryTree<>(65, null, null);
        BinaryTree<Integer> thirtyone = new BinaryTree<>(31, ninetyseven, null);
        BinaryTree<Integer> thirtysix = new BinaryTree<>(36, eightyfive, sixtytwo);
        BinaryTree<Integer> fortyone = new BinaryTree<>(41, sixtyfive, fiftyfour);
        BinaryTree<Integer> fortythree = new BinaryTree<>(43, thirtysix, thirtyone);
        BinaryTree<Integer> eight = new BinaryTree<>(8, fortythree, fortyone);
        return eight;
    }
}
