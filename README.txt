command line argument
`java FlipPancake array/list N`

§ Description of your algorithm for flipping the pancakes and the analysis of the worse-case being (3n-2) flips.
NOTE - the output samples provided in HW2-instructions do not match the outputs from my algorithm. However, the way I wrote my algorithm still executes and runs under the requirements of the instructions.
Step 1. given a parsed array from the command line argument, push those elements in the required data structure. To find how many top pancakes to flip, use a pointer as a comparison.
Ex. given array - {+1, +2, +3, -4, +5}, pointer being +1 to compare with the rest of the elements.
    1a. push(+5);
    1b. is +5 <= p? <=> is +5 <= +1? No, 5 isn't less than 1 so p is still 1.
    2a. push(-4);
    2b. is -4 <= p? <=> is -4 <= +1? Yes, p is now -4.
    // and so forth.
    Result from step 1: stack from top - [+1, +2, +3, -4, +5], pointer = -4.
Step 2. set pointer = -pointer. Doing this, will tell us how many top pancakes to flip. (NOTE: will need to add pointer value to an array like ArrayList so we can print the sequence as output later). Pop pointer times into an array and convert the signs.
Ex. given array - {+1, +2, +3, -4, +5}, stack from top - [+1, +2, +3, -4, +5], pointer being -4 from step 1.
    1a. pop(+1);
    1b. new_array - {-1}, stack from top - [+2, +3, -4, +5]
    2a. pop(+2);
    1b. new_array - {-1, -2}, stack from top - [+3, -4, +5]
    // and so forth.
    Result from step 2: new_array - {-1, -2, -3, +4}, stack from top - [+5].
Step 3. set pointer = first index value to compare with the rest of the elements. Push the array elements in the required data structure. This has now been 1 flip; increment the amount of flips.
Ex. given array - {+1, +2, +3, -4, +5}, new_array - {-1, -2, -3, +4}, stack from top - [+5], pointer = -1.
    1a. push(-1);
    1b. is -1 <= p? <=> is -1 <= -1? Yes, p is still -1.
    2a. push(-2);
    2b. is -2 <= p? <=> is -2 <= -1? Yes, p is -2.
    // and so forth.
    Result from step 3: stack from top - [+4, -3, -2, -1, +5].
Step XX. repeat steps 2 and 3. 

§ On which platform (mac, linux, window) the code is compiled and executed - mac

§ "Resources that Helped Me" - 
textbook.
Kenneth Lord
https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
https://stackoverflow.com/questions/36894895/how-to-take-stringtokenizer-result-to-arraylist-in-java
https://introcs.cs.princeton.edu/java/43stack/ResizingArrayStackOfStrings.java.html
