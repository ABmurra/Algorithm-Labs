import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

/*	
* Write one or more methods that attempt to discover the unencrypted or "plaintext" passwords for each username.
* Make sure your program runs correctly and produces the desired output.
*/

public class HashTableTester {

	private static int hash(String password)
	{
	    return Math.abs(password.hashCode());
	}
	
	public static void hashTableTester() throws FileNotFoundException { 
		
		Hashtable<String, Integer> passwords = new Hashtable<String, Integer>();
			
		String line = "";
		String username = "";
		int hashcode = 0;
		
		// Read in the passwords.txt file, disregarding any comments (lines starting with #)
		Scanner read = new Scanner(new File("bin/passwords.txt"));
		
		while(read.hasNextLine()) {
			
			line = read.nextLine();
			if (!line.contains("#"))
			{
				String[] parts = line.split(":");
				username = parts[0];
				hashcode = Integer.parseInt(parts[1]);
			}
			
			// Store the user names and encrypted passwords in a Hashtable object.
			passwords.put(username, hashcode);
		}

		// Try to crack each password
		for (String name : passwords.keySet())
		{
			int hashSlingingSlasher = passwords.get(name);
			String combo = "";

			// Make guesses by trying all combinations of 5 characters
			loopA :
			for (char c1 = '0'; c1 <= 'Z'; c1++) 
				    for (char c2 = '0'; c2 <= 'Z'; c2++) 
				        for (char c3 = '0'; c3 <= 'Z'; c3++) 
				            for (char c4 = '0'; c4 <= 'Z'; c4++) 
				            	for (char c5 = '0'; c5 <= 'Z'; c5++) {
				            		combo = "" + c1 + c2 + c3 + c4 + c5;
				            		if (hashSlingingSlasher == hash(combo)) {
				            			System.out.println("5-letter password for username " + name + " is " + combo);
				            			break loopA;
				            		}
				            		
				            		else if (c1 == 'Z') {
				            			if (hashSlingingSlasher != hash(combo)) {
				            				System.out.println("Could not crack 5-letter password for username " + name);
				            				break loopA;
				            			}
				            		}
				            	}
		}
		
		for (String name : passwords.keySet())
		{
			int hashSlingingSlasher = passwords.get(name);
			String combo = "";
			
			// Make guesses by trying all combinations of 6 characters
			loopB : 
			for (char c1 = 'a'; c1 <= 'z'; c1++) 
				    for (char c2 = 'a'; c2 <= 'z'; c2++) 
				        for (char c3 = 'a'; c3 <= 'z'; c3++) 
				            for (char c4 = 'a'; c4 <= 'z'; c4++) 
				            	for (char c5 = 'a'; c5 <= 'z'; c5++) 
				            		for (char c6 = 'a'; c6 <= 'z'; c6++) {
				            			combo = "" + c1 + c2 + c3 + c4 + c5 + c6;
					            		if (hashSlingingSlasher == hash(combo)) {
					            			System.out.println("6-letter password for username " + name + " is " + combo);
					            			break loopB;
					            		}
					            		else if (c1 == 'z') {
					            			if (hashSlingingSlasher != hash(combo)) {
					            				System.out.println("Could not crack 6-letter password for username " + name);
					            				break loopB;
					            			}
					            		}
					            		
				            		}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Reading in password file...\nCracking passwords...");
		hashTableTester();
		System.out.println("Done.");

	}
	
}
