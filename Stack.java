/* 
 * @author Michelle Yu.
 * */
public interface Stack<E> {
	/* @return number of elements in the stack.
	 * */
	int size();
	
	/* @return true if empty in the stack.
	 * */
	boolean isEmpty();
	
	/* @param e, the element to be inserted.
	 * */
	void push(E e);
	
	/* @return removes and returns first element in stack.
	 * */
	E pop();
	
	/* @return returns first element in stack but doesn't remove.
	 * */
	E peek();
}