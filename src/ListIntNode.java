/**
 * A class used for storing a single node of a singly linked list whose data is
 * an integer. It has two public instance fields for 1) the integral data and 2) the link
 * to the next node in the list.
 */
public class ListIntNode {
    public int data;          // data stored in this node
    public ListIntNode next;  // link to next node in the list


    /**
     * Constructs a node with data 0 and null next
     */
    public ListIntNode() {
        this(0, null);
    }


    /**
     * Constructs a node with given data and null next
     * @param data integer data file
     */
    public ListIntNode(int data) {
        this(data, null);
    }

    /**
     * Constructs a node with the g
     * @param data integer data value
     * @param next link to next node
     */
    public ListIntNode(int data, ListIntNode next) {
        this.data = data;
        this.next = next;
    }
}