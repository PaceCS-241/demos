public class WaitingList {
    public static void main(String[] args) {
        WLinkedList waitList = new WLinkedList();

        Node meher = new Node("Meher");

        
    }
}


class WLinkedList {
    Node head;

    public WLinkedList() {
        this.head = null;
    }
}

class Node{
    // linked list node, stores students
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }

    public boolean matchName(String searchName) {
        // return if the given searchName matches name
        return false;
    }

} 