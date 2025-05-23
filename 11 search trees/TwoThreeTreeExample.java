public class TwoThreeTreeExample {
    public static void main(String[] args) {
        TTNode<Integer> testTree = new TTNode<Integer>(7, null, 
            new TTNode<Integer>(3, null, null, null, null), 
            new TTNode<Integer>(11, null, null, null, null), 
            null);


        System.out.println(testTree);
    }
    
}
