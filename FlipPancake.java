import java.util.*;
/* Main program to run the algorithm in the required data structures.
 * @author Michelle Yu
 * */
public class FlipPancake {
	public static void main(String args[]) {
		try {
			int n = args.length;
			if (n < 2) {
				System.out.println("java FlipPancake array/list N");
				return;
			}
			String flip_top_n;
			String dtype = args[0]; // array or list

			if (dtype.equals("array")) {
				flip_top_n = args[1];
				parseAStack(flip_top_n); // parse string to int.
			}

			else if (dtype.equals("list")) {
				flip_top_n = args[1];
				parseLStack(flip_top_n);
			}

			else {
				System.out.println("The first argument has to be either array or list.");
				return;
			}
		} catch (Exception e) {
			System.out.println("NULL: Something is wrong");
			return;
		}
	}
	/* If the argument is array, turn the command line argument into an int array. Uses Scanner and StringTokenizer to read and make tokens. The tokens will then be parsed as int into the array so it can be used to call on the pancakeOutput method.
	* @param flip_top_n		a string that needs to be parsed into an int array. Param example: "3 +1 -3 -2"
	* */
	private static void parseAStack(String flip_top_n) { 
		Scanner in = new Scanner(flip_top_n);
		String stg = in.nextLine();
	
	    StringTokenizer st = new StringTokenizer(stg);		
	    String[] arr = new String[st.countTokens()];
	    int[] numarr = new int[arr.length];
    	int i = 0;

	    while (st.hasMoreTokens()){
	    	String token = st.nextToken();
	    	arr[i] = token;
	    	numarr[i] = Integer.parseInt(token);
			++i;
		}
		ArrayStack<Integer> as = new ArrayStack<>();

		as.pancakeOutput(numarr);
		in.close();
		
	}

	/* If the argument is list, turn the command line argument into an int array. Uses Scanner and StringTokenizer to read and make tokens. The tokens will then be parsed as int into the array so it can be used to call on the pancakeOutput method.
	* @param flip_top_n		a string that needs to be parsed into an int array. Param example: "3 +1 -3 -2"
	* */
	private static void parseLStack(String flip_top_n) {
		Scanner in = new Scanner(flip_top_n);
		String stg = in.nextLine();
	
	    StringTokenizer st = new StringTokenizer(stg);		
	    String[] arr = new String[st.countTokens()];
	    int[] numarr = new int[arr.length];
    	int i = 0;

	    while (st.hasMoreTokens()){
	    	String token = st.nextToken();
	    	arr[i] = token;
	    	numarr[i] = Integer.parseInt(token);
			++i;
		}
		ListStack<Integer> ls = new ListStack<>();
		
		ls.pancakeOutput(numarr);

		in.close();
	}

}

/* Resources that helped me - 
 * textbook.
 * Kenneth Lord
 * https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * https://stackoverflow.com/questions/36894895/how-to-take-stringtokenizer-result-to-arraylist-in-java
 * https://introcs.cs.princeton.edu/java/43stack/ResizingArrayStackOfStrings.java.html
 * */