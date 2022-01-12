import java.util.Scanner;
import java.util.Random;

public class TreeTester {

	
	/*
	 * This method creates a binary search tree (BST) of strings (using MyBST), prompts the user for a sentence,
	 * and displays the words from the sentence in alphabetical order.
	 */
	public static void testWordOrder() {
		MyBST<String> words = new MyBST<String>();
		
		System.out.print("Enter a sentence > ");
		Scanner keyboard = new Scanner(System.in);
		String sentence = keyboard.nextLine();
        keyboard.close();
        
        sentence = sentence.toLowerCase();
        String[] eachWord = sentence.split("\\W+"); // splits sentence into words
        
        // add each word to words tree
        for (int i = 0; i < eachWord.length; i++) 
        {
			eachWord[i] = eachWord[i].replaceAll("[^\\w]", "");
			words.add(eachWord[i]);
		}  
        words.printInOrder(" ");
	}
	
	/*
	 * This method creates a BST of integers, generates 1,000 random numbers between 1 and 1,000
	 * and stores them in the BST. It then generates 20 more random numbers in the same range
	 * and reports for each whether or not it is contained in the BST.
	 */
	public static void testRandomNumbers() {
		MyBST<Integer> numbers = new MyBST<Integer>();
		Random random = new Random();
		
		// generates 1000 random numbers b/w 1 and 1,000
		for (int i = 1; i <= 1000; i++) 
		    numbers.add(random.nextInt(1000) +1);
		
		// generates 20 more random numbers b/w 1 and 1,000 and reports status
		for (int i = 1; i <= 20; i++)  {
		    int j = random.nextInt((1000) +1);
		    if (numbers.contains(j)) 
		    	System.out.println("Tree contains " + j);
		    if (!numbers.contains(j))
		    	System.out.println("Tree does not contain " + j);
		}
		    
	}
	
	/*
	 * This method creates a BST of integers (once again using MyBST), generates 1,000 random numbers 
	 * between 1 and 1,000 and stores them in the BST. It then outputs the average value of the numbers 
	 * and how many of the numbers are less than that average
	 */
	public static void testMoreNumbers() {
		MyBST<Integer> moreNumbers = new MyBST<Integer>();
		Random random = new Random();
		int sum = 0;
		int average = 0;
		int lessThan = 0;
		
		// generates 1000 random numbers b/w 1 and 1,000 and calculates sum
		for (int i = 1; i <= 1000; i++) {
		    int j = random.nextInt(1000) +1;
		    sum += j;
		    moreNumbers.add(j);
		}
	    
		average = sum / moreNumbers.size();
	    System.out.println("The average value of numbers is " + average);
		
		// calculate how many of the numbers are less than the average & System.out.prinln it
	    for (int n = 0; n < average; n++) {
	    	while (moreNumbers.contains(n)) {
	    	    moreNumbers.remove(n);
	    	    lessThan++;
	    	}
	    }
	    System.out.println("There are " + lessThan + " numbers less than the average, " + average);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Testing Word Order =======================");
		testWordOrder();
		System.out.println("\n==========================================\n");
		
		System.out.println("Testing Random Numbers ===================");
		testRandomNumbers();
		System.out.println("==========================================\n");
		
		System.out.println("Testing More Numbers =====================");
		testMoreNumbers();
		System.out.println("==========================================\n");
	}

}