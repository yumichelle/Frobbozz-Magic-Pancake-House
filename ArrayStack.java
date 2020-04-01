import java.util.ArrayList;
import java.util.Iterator;

/* 
 * @author Michelle Yu
 * */
public class ArrayStack<T> implements Stack<T> {
	private T[] aStack;
	private static int capacity = 0; 
	private int top_idx = 0; 
	private ArrayList<Integer> sequence = new ArrayList<>();
	private int flipped;
	
	public ArrayStack() {
		this(capacity);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		aStack = (T[]) new Object[capacity];
	}

	@Override
	public int size() {
		return ++top_idx;
	}

	@Override
	public boolean isEmpty() {
		return top_idx == 0;
	}

	@Override
	public void push(T num) {
		if(capacity==aStack.length) {
			resize(2*aStack.length);
		}
		aStack[++top_idx] = num;

		if (isEmpty()) throw new IllegalStateException("Stack is full.");
	}
	
	public void resize(int n) {
        assert n >= capacity;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[n];
		for (int i = 0; i < capacity; ++i) temp[i] = aStack[i];
		aStack = temp;
	}

	@Override
	public T pop() {
		if (isEmpty()) return null;
		T remove = aStack[top_idx];
//		if (size() == 0)
//			aStack[top_idx] = null;
		aStack[top_idx--] = null; // dereference for garbage collection.
		return remove;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		return aStack[top_idx];
	}

	@SuppressWarnings("rawtypes")
	public void pancakeOutput(int[] arr) {
		capacity = arr[0];
		ArrayStack<Integer> data = new ArrayStack<>(capacity); //push arr into a stack.
		
		int pointer = arr[1];
		
		for(int i = capacity; i >= 1; --i){ // goes backwards.
			if(arr[i] <= pointer) pointer = arr[i];
			data.push(arr[i]);
			size();
		}

		flip(data, pointer);
		sequence.add(0, flipped);

		int[] output = new int[top_idx];
		
		for (int i = 0; i < top_idx; ++i) {
			output[i] = data.pop();
		}
	    selectionSort (output, output.length);
	    
	    Iterator iter = sequence.iterator();
	    while (iter.hasNext()) {
	        System.out.print(" " + iter.next());
	    }
		System.out.println();
	}
	
	public void flip(ArrayStack<Integer> data, int pointer) {
		pointer = -(pointer); // to tell us how many pancakes to flip.
		sequence.add(pointer);
			      
		int[] temp = new int[pointer];
		for(int i = 0; i<pointer; ++i) {
			int n = -(data.pop());
			temp[i] = n;
		}
		pointer = temp[0];
		for(int i = 0; i<temp.length; ++i){ // goes forwards.
			data.push(temp[i]);
			if(temp[i] <= pointer) pointer = temp[i];
		}
		if(pointer < 0) flip(data, pointer);

		flipped+=1;
	}
	
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
	         }  // if
	      } // for i 
	 }
	
}