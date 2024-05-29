/**
 * A class used for storing a single node of a singly linked list whose data is
 * generic. It has two public instance fields for 1) the generic data and 2) the link
 * to the next node in the list.
 */
public class ListNode<E> {

    public E data;
    public ListNode<E> next;

    /**
     * Constructs a ListNode with the generic data and null next
     * @param data generic data parameter
     */
    public ListNode(E data) {
        this(data, null);
    }


    /**
     * Constructs a ListNode with the generic data and  next link
     * @param data generic data
     * @param next link to next
     */
    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }
    
    
}