import java.util.ArrayList;
import java.util.Iterator;

/* uses an Singly Linked List inner class to use ListStack with Stack interface.
 * @author Michelle Yu
 * */

public class ListStack<T> implements Stack<T> {
	/* Inner class SinglyLinkedList uses inner class Node to create the nodes for Singly Linked List.
	* Some methods are added just in case even though they aren't necessary for this project.
	* */
	private static class SinglyLinkedList<T> {
		private static class Node<T> {
			private T data;
			private Node<T> next;
	
			public Node(T d, Node<T> n) {
				data = d;
				next = n;
			}
	
			public T getData() {
				return data;
			}
	
			public Node<T> getNext() {
				return next;
			}
	
			public void setNext(Node<T> n) {
				next = n;
			}
		}
		private Node<T> head = null, tail = null;
		private int size;
		
		public SinglyLinkedList() {}
		public int size() { return size; }
		public boolean isEmpty() { return size == 0; }
		public T first() {
			if(isEmpty()) return null;
			return head.getData();
		}
		@SuppressWarnings("unused")
		public T last() {
			if(isEmpty()) return null;
			return tail.getData();
		}
		public void addFirst(T t) {
			head = new Node<>(t, head);
			if(size==0) tail = head;
			++size;
		}
		@SuppressWarnings("unused")
		public void addLast(T t) {
			Node<T> newest = new Node<>(t, null);
			if(isEmpty()) head = newest;
			else tail.setNext(newest);
			++size;
		}
		public T removeFirst() {
			if(isEmpty()) return null;
			T remove = head.getData();
			head = head.getNext();
			--size;
			if(size==0) tail = null;
			return remove;
		}
	}
	
	private int top_idx = 0; // element top of the stack.
	private ArrayList<Integer> sequence = new ArrayList<>();
	private int flipped; // how many times pancakes have been flipped.
	private SinglyLinkedList<T> list = new SinglyLinkedList<>(); // an empty list.

	/* ListStack constructor; relies on the initially empty list.
	*/
	public ListStack() {}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(T e) {
		list.addFirst(e);
	}

	@Override
	public T pop() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.first();
	}

	/* Calls on methods flip and selectionSort, then will print the sequence detailing how many flips total and top x pancakes that was flipped.
	* The first element of the array is how many pancakes there are.
	* @param arr	1-D array from the command line argument.
	*/
	@SuppressWarnings("rawtypes")
	public void pancakeOutput(int[] arr) {
		int capacity = arr[0];
		ListStack<Integer> data = new ListStack<>();
		int pointer = arr[1];
		
		for(int i = capacity; i >= 1; --i){ // goes backwards.
			if(arr[i] <= pointer) pointer = arr[i];
			data.push(arr[i]);
			data.size();
		}

		flip(data, pointer);
		sequence.add(0, flipped);

		int[] output = new int[top_idx];
		
		for (int i = 0; i < top_idx; ++i) {
			output[i] = data.pop();
		}
	    selectionSort(output, output.length);
	    
	    /*Looping ArrayList using Iterator*/
	    Iterator iter = sequence.iterator();
	    while (iter.hasNext()) {
	        System.out.print(" " + iter.next());
	    }
		System.out.println();
	}

	/* Flips the pancakes pushed into the ListStack. 
	* Keeps calling itself if there are pancakes to be flipped when the pointer is negative. Outcome: We want all the pancakes to be positive because + means a burnt bottom.
	* The pancake with the lowest number (-#) is also how many pancakes that needs to be flipped.
	* @param data	the pancakes to flip.
	* @param pointer	how many pancakes to flip.
	*/
	public void flip(ListStack<Integer> data, int pointer) {
		pointer = -(pointer); 
		sequence.add(pointer);
			      
		int[] temp = new int[pointer]; 
		for(int i = 0; i<pointer; ++i) {
			int n = -(data.pop());
			temp[i] = n;
		}

		pointer = temp[0];
		for(int i = 0; i<temp.length; ++i){ 
			data.push(temp[i]);
			if(temp[i] <= pointer) pointer = temp[i]; // finds the lowest number because that will tell us how many pancakes to flip.
		}
		if(pointer < 0) flip(data, pointer); // if pointer is negative, there are more pancakes to flip.

		flipped+=1;
	}

	/* Sorts the outcome from the flip method from lowest to highest. 
	* @param output		all + pancakes because each pancake has a burnt bottom.
	* @param length		how many pancakes there are.
	*/
	public static void selectionSort (int[] output, int length) { 
	      for ( int i = 0; i < length - 1; i++ ) { 
	         int indexLowest = i; 
	         for ( int j = i + 1; j < length; j++ ) 
	            if ( output[j] < output[indexLowest] ) 
	               indexLowest = j;
	         if ( output[indexLowest] != output[i] ) { 
	            int temp = output[indexLowest];
	            output[indexLowest] = output[i]; 
	            output[i] = temp; 
	         } 
	      } 
	 }
	
	
}