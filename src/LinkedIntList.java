import java.lang.*;

/**
 * This class allows singly-linked lists to be constructed and manipulated
 */
public class LinkedIntList {

    private ListNode<Integer> front;
    private int size; //O(1)

    /**
     * Constructs a LinkedIntList with no nodes, front is set to null
     */
    public LinkedIntList() {
        front = null;
        size = 0;
    }

    /**
     * Constructs a LinkedIntList and sets the front to the head ListNode
     * passed to it.  Note: head may already be connected to other ListNodes
     *
     * @param head ListNode to become the front of the linked list
     */
    public LinkedIntList(ListNode<Integer> head) {
        front = head;
        size = size2();
    }

    /**
     * Constructs a singly linked list with one ListNode storing an integer
     * value
     *
     * @param value data value to store in the ListNode
     */
    public LinkedIntList(int value) {
        front = new ListNode<>(value, null);
        size = 1;
    }

    /**
     * Adds a new list node to the front of the singly linked list
     *
     * @param value Note: You need to change the front instance field reference
     *              to point at this new node
     */
    public void addFront(int value) {

        if (front == null) {
            front = new ListNode<>(value, null);
        } else {
            front = new ListNode<>(value, front);
        }
        size++;

    }

    /**
     * Add a list node to the end of the singly linked list
     *
     * @param value integer value to add
     */
    public void addEnd(int value) {
        if (front == null) {
            addFront(value);
        } else {
            ListNode<Integer> curr = front;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode<>(value);
            size++;
        }
    }

    /**
     * Removes the first node in the list and returns the data value
     * stored in the removed node
     *
     * @return integer data value that was removed
     * <p>
     * Note: if front is null, throw an IllegalStateException("No node to remove");
     */
    public int removeFront() {
        if (front == null) {
            throw new IllegalStateException("no node to remove.");
        } else {
            int removed = front.data;
            front = front.next;
            size--;
            return removed;
        }
    }

    /**
     * Traverses to the NEXT to last node and removes the last list node
     * in the singly linked list by setting current.next to null. Make sure you
     * save the removed value before setting .next to null, so you can return it.
     *
     * @return integer data value that was removed
     *
     * Note: if front is null, throw an IllegalStateException("No node to remove");
     */
    public int removeEnd() {

        if (front == null) {
            throw new IllegalStateException("no node to remove");
        }

        int removed = front.data;

        if (front.next == null) {
            front = null;
        } else {
            ListNode<Integer> curr = front;

            while (curr.next.next != null) {
                curr = curr.next;
            }

            removed = curr.next.data;
            curr.next = null;
        }
        size--;
        return removed;

    }

    /**
     * Determines if the value is in a list node in the singly linked list
     * @param value integer data value to search for
     * @return true if value is found, false otherwise
     */
    public boolean contains(int value) {
        ListNode<Integer> current = front;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * This size2 method has an O(n) time complexity since it traverses the entire
     * list to count the number of nodes
     * @return the number of list nodes
     */
    public int size2() {
        int count = 0;
        ListNode<Integer> curr = front;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;

    }

    /**
     * Returns the number of nodes in the list. This is an O(1) implementation as the
     * retrieval occurs in constant time
     * @return number of nodes
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[" + front.data);
        ListNode<Integer> curr = front.next;

        while (curr != null) {
            result.append(",").append(curr.data);
            curr = curr.next;
        }

        result.append("]");
        return result.toString();
    }

    /**
     * Adds a node at the given index
     * @param index integer in range 0 to size
     * @param value integer to add to the list
     *
     *
     */
    public void add(int index, int value) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("index out of bounds for size == 0");
        }
        if ( index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addEnd(value);
        }
        if (index == 0) {
            addFront(value);
        }

        ListNode<Integer> curr = front;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = new ListNode<Integer>(value, curr.next);
        size++;
    }

    /**
     * Returns the data value for a node at a given index
     * @param index indicates position in list from 0 to size - 1
     * @return data value for node
     */
    public int get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("index out of bounds for size == 0");
        }

        if ( index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<Integer> curr = front;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    // Your TODO - Remember you can reuse removeFront if index = 0
    //             and removeEnd if index = size - 1

    /**
     * Removes the node at the given index
     * @param index numerical index number in range 0 to size - 1
     * @return data value being removed
     */
    public int remove(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("index out of bounds for size == 0");
        }
        if ( index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size - 1) {
            removeEnd();
        }
        if (index == 0) {
            removeFront();
        }

        ListNode<Integer> curr = front;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        int removed = curr.next.data;
        curr.next = curr.next.next;
        size--;

        return removed;
    }

    // Your TODO

    /**
     * Overwrites the value in the list at the given index with the given value
     * @param index numerical index value in range 0 to size - 1
     * @param value value to set in list
     */
    public void set(int index, int value) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("index out of bounds for size == 0");
        }

        if ( index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<Integer> curr = front;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.data = value;
    }
}