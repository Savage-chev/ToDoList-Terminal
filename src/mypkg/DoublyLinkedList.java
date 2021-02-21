package mypkg;

/**
 * @author (Plamen Savchev)
 * @version (1.3 25/11/20)
 * 
 * class DoublyLinkedList represent the data structure of the ToDo Application.
 * The class will link together the objects by the nested Node class.
 */

public class DoublyLinkedList<E> implements List<E> {

	/**----- nested static Node class -----
	* the following class is called inner class and is used by the outer
	* class so create elements(nodes) to be added to the list 
	*/
	
	/** A static nested class may be instantiated without instantiating the outer class */
	private static class Node<E> {
		private E element;                   // reference to the element stored at this node
		private Node<E> prev;                // reference to the previous node in the list
		private Node<E> next;                // reference to the next node in the list
		
		/**
	     * Constructor for objects of class Node
	     */
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		/**
	     * It's a good practice to use get/set method instead of accessing directly the fields
	     */
		public E getElement() { 
			return element; }
		public Node<E> getPrev() { 
			return prev; }
		public Node<E> getNext() { 
			return next; }
		public void setPrev(Node<E> prev) { 
			this.prev = prev; }
		public void setNext(Node<E> next) { 
			this.next = next; }
	}
	
	//----- end of nested static Node class -----
	
	// instance variables of the DoublyLinkedList
	private Node<E> header;                 // header sentinel
	private Node<E> trailer;                // trailer sentinel
	private int size = 0;                   // number of nodes (excluding the sentinels)
	
	/** Construct new empty list */
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	// PUBLIC GET METHODS
	
	/** Return the size(number of elements) in the linked list 
	 * @return Integer */
	public int size() {
		return size;
	}
	
	/** Return whether the list is empty or not
	 * @return Boolean true==empty */
	public boolean isEmpty() {
		return size==0;
	}
	
	/** Return the first element of the list (not delete) 
	 * @return first node */
	public E first() {
		if (isEmpty()) 
			return null; 
		else 
			return header.getNext().getElement();   // first element after the sentinel/header
	}
	
	/** Return the last element of the list (not deleted) 
	 * @return last node */
	public E last() {
		if (isEmpty()) return null;
		return trailer.getNext().getElement();      // last element before the sentinel/trailer
	}
	
	/** Takes index as argument and return element at index 
	 * @return */
	public E getByIndex(int index) {
		if (isEmpty()) return null;
		int i;
		Node<E> trav;
        //Search from the front of the list
        if (index < size/2) {
        	//current = header;
    		for (i=0, trav = header; i<index; i++)
    			trav = trav.getNext();
        }
        //Search from the back of the list
        else {
        	//current = trailer;
    		for (i=size+1, trav = trailer; i!=index; i--)
    			trav = trav.getPrev();
        }
        return trav.getElement();
	}
	
	/** Takes sequence of characters as argument and return the return the element if
	 * contain those characters. Otherwise returns null.
	 * @return <code>Node</code> object if contains passed <code>String</code>*/
	private E getByName(Node<E> current, String sequenceOfChar) {
		if (isEmpty()) return null;

		String task = String.valueOf(current.getElement());
		
		if (task.toLowerCase().contains(sequenceOfChar)) {
			return current.getElement();
		}
		else {
			return null;
		}
	}
	
	/** Takes string as argument and pass it to the <code>getByName()</code> method.
	 * Print all the <code>Node</code> elements returned by the above method.*/
	public void getAllMatches(String sequenceOfChar) {
		Node<E> current;
		current = header.getNext();

		while (current != null) {
			getByName(current,sequenceOfChar);
			if (!current.equals(null)) {
				System.out.println(getByName(current,sequenceOfChar));
			}
			current = current.getNext();
		}
	}
	
	/** Method walks forward through the doubly linked list
	 * @get all <code>Node</code> in element head to tail order */
	public void iterateForward() {
		if (isEmpty()) System.out.println("List is empty!");
		int i=0;
		Node<E> current;
		
		current = header.getNext(); 
		while (current != null && i < size()) {
			System.out.println(current.getElement());
			current = current.getNext();
			i++;
		}	
	}
	
	/** Method walks backward through the doubly linked list
	 * @get all <code>Node</code> element in tail to head order */
	public void iterateBackward() {
		if (isEmpty()) System.out.println("List is empty!");
		int i=0;
		Node<E> current;
		
		current = trailer.getPrev(); 
		while (current != null && i < size()) {
			System.out.println(current.getElement());
			current = current.getPrev();
			i++;
		}
	}
	
	// PUBLIC SET / UPDATE METHODS
	
	/** Adds element to the front of the list 
	 * @add <code>Node</code> element */
	public void addFirst(E element) {
		addBetween(element, header, header.getNext());  // insert after the front sentinel
	}
	
	/** Adds element to the rear of the list 
	 * @add <code>Node</code> element */
	public void addLast(E element) {
		addBetween(element, trailer.getPrev(), trailer);  // insert before the rear sentinel
	}
	
	/** Removes & return element from the front of the list 
	 * @remove @return <code>Node</code> element */
	public E removeFirst(E element) {
		if (isEmpty()) return null;               // nothing to remove
		return remove(header.getNext());          // first element after the sentinel/header
	}
	
	/** Removes & return element from the rear of the list 
	 * @remove & @return <code>Node</code> element */
	public E removeLast(E element) {
		if (isEmpty()) return null;               // nothing to remove
		return remove(trailer.getPrev());         // last element before the sentinel/trailer
	}
	
	/** Removes & return element from the doubly linked list by position its position
	 * @remove & @return <code>Node</code> element by index. Accept <code>int</code> as parameter */
	public E removeByIndex(int index) {
		if (isEmpty()) return null;
        int i;
        Node <E> trav;
        // negative indexes are always invalid
        // However, index out of boundaries has been handled in the main class
        //if (index < 1 || index > size()) {
        //    throw new IndexOutOfBoundsException();
        //}
        
        //Search from the front of the list
        if (index < size/2) {
        	for (i = 0, trav = header; i != index; i++)
        		trav = trav.getNext();
        }
        //Search from the back of the list
        else
            for (i = size+1, trav = trailer; i != index; i--)
            	trav = trav.getPrev();
        	
        return remove(trav);
    }
	
	/** adds element between given nodes in the list 
	 * @add <code>Node</code> element */
	private void addBetween(E element, Node<E> predecessor, Node<E> successor) {
		//create and link new node
		Node<E> newest = new Node<E>(element, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	/** removes & return given node from the list 
	 * @return & @remove <code>Node</code> element */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
}