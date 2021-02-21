package mypkg;

/**
 * @author (Plamen Savchev)
 * @version (1.3 23/11/20)
 * 
 * <code>Interface</code> <code>List<E></code> provides collection of methods
 * to be implemented.
 */

public interface List<E> {
	
	/** Return the size(number of elements) in the linked list 
	 * @return Integer */
	public int size();
	
	/** Return whether the list is empty or not
	 * @return Boolean true==empty */
	public boolean isEmpty();
	
	/** Return the first element of the list (not delete) 
	 * @return first node */
	public E first();
	
	/** Return the last element of the list (not deleted) 
	 * @return last node */
	public E last();
	
	/** Takes index as argument and return element at index 
	 * @return */
	public E getByIndex(int index);
	
	/** Takes string as argument and pass it to the <code>getByName()</code> method.
	 * Print all the <code>E</code> elements returned by the above method. */
	public void getAllMatches(String sequenceOfChar);
	
	/** Method walks forward through the doubly linked list
	 * @get all <code>E</code> elements, head to tail order */
	public void iterateForward();
	
	/** Method walks backward through the doubly linked list
	 * @get all <code>E</code> elements, tail to head order */
	public void iterateBackward();
	
	/** Adds element to the front of the list 
	 * @add <code>E</code> element */
	public void addFirst(E element);
	
	/** Adds element to the rear of the list 
	 * @add <code>E</code> element */
	public void addLast(E element);
	
	/** Removes & return element from the front of the list 
	 * @remove @return <code>E</code> element */
	public E removeFirst(E element);

	/** Removes & return element from the rear of the list 
	 * @remove & @return <code>E</code> element */
	public E removeLast(E element);
	
	/** Removes & return element from the doubly linked list by position its position
	 * @remove & @return <code>E</code> element by index. Accept <code>int</code> as parameter */
	public E removeByIndex(int index);
}
