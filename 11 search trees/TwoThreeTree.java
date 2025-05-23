/*
    * Algorithm from Ville Karavirta and Cliff Shaffer 
    * https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/TwoThreeTree.html
    */

// 2-3 tree node implementation
class TTNode<E extends Comparable<? super E>> {
    private E lval;        // The left record
    private E rval;        // The right record
    private TTNode<E> left;   // Pointer to left child
    private TTNode<E> center; // Pointer to middle child
    private TTNode<E> right;  // Pointer to right child

    public TTNode() { center = left = right = null; }
    public TTNode(E lv, E rv,
                TTNode<E> p1, TTNode<E> p2,
                TTNode<E> p3) {
        lval = lv; rval = rv;
        left = p1; center = p2; right = p3;
    }

    public boolean isLeaf() { return left == null; }
    public TTNode<E> lchild() { return left; }
    public TTNode<E> rchild() { return right; }
    public TTNode<E> cchild() { return center; }
    public E lval() { return lval; }  // Left value
    public E rval() { return rval; }  // Right value
    public void setLeft(E e) { lval = e; }
    public void setRight(E e) { rval = e; }
    public void setLeftChild(TTNode<E> it) { left = it; }
    public void setCenterChild(TTNode<E> it)
    { center = it; }
    public void setRightChild(TTNode<E> it)
    { right = it; }

    public TTNode<E> inserthelp(TTNode<E> rt, E e) {
        TTNode<E> retval;
        if (rt == null) {// Empty tree: create a leaf node for root
            return new TTNode<E>(e, null, null, null, null);
        }
        if (rt.isLeaf()) { // At leaf node: insert here
            return rt.add(new TTNode<E>(e, null, null, null, null));
        }
        // Add to internal node
        if (e.compareTo(rt.lval()) < 0) { // Insert left
            retval = inserthelp(rt.lchild(), e);
            if (retval == rt.lchild()) { return rt; }
            else { return rt.add(retval); }
        }
        else if((rt.rval() == null) || (e.compareTo(rt.rval()) < 0)) {
            retval = inserthelp(rt.cchild(), e);
            if (retval == rt.cchild()) { return rt; }
            else { return rt.add(retval); }
        }
        else { // Insert right
            retval = inserthelp(rt.rchild(), e);
            if (retval == rt.rchild()) { return rt; }
            else { return rt.add(retval); }
        }
    }
        
        // Add a new key/value pair to the node. There might be a subtree
        // associated with the record being added. This information comes
        // in the form of a 2-3 tree node with one key and a (possibly null)
        // subtree through the center pointer field.
    private TTNode<E> add(TTNode<E> it) {
        if (rval == null) { // Only one value, add here
            if (lval.compareTo(it.lval()) < 0) {
            rval = it.lval(); rval = it.lval();
            center = it.lchild(); right = it.cchild();
            }
            else {
            rval = lval; right = center;
            lval = it.lval();
            center = it.cchild();
            }
            return this;
        }
        else if (lval.compareTo(it.lval()) >= 0) { // Add left
            TTNode<E> N1 = new TTNode<E>(lval, null, it, this, null);
            it.setLeftChild(left);
            left = center; center = right; right = null;
            lval = rval; rval = null;
            return N1;
        }
        else if (rval.compareTo(it.lval()) >= 0) { // Add center
            it.setCenterChild(new TTNode<E>(rval, null, it.cchild(), right, null));
            it.setLeftChild(this);
            rval = null; right = null;
            return it;
        }
        else { // Add right
            TTNode<E> N1 = new TTNode<E>(rval, null, this, it, null);
            it.setLeftChild(right);
            right = null; rval = null;
            return N1;
        }
    }

    public String toString() {
        return toString("");
    }

    public String toString(String prefix) {
        String result = prefix;
        result = result + lval.toString();
        if(rval != null)
            result = result + " | " + rval.toString();
        if(left != null && left.lval != null) {
            result = result + "\n" + prefix + "  " + left.toString(prefix + "  ");   
        }
        if(center != null && center.lval != null) {
            result = result + "\n" + prefix + "  " + center.toString(prefix + "  ");     
        }
        if(right != null && right.lval != null) {
            result = result + "\n" + prefix + "  " + right.toString(prefix + "  ");
        }
        return result;
    }
}   
