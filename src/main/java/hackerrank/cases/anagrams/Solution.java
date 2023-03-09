package hackerrank.cases.anagrams;

import java.util.Scanner;

public class Solution {
    
    private final static String EMPTY = "";
    private final static String SPACE = " ";

    static boolean isAnagram(String a, String b) {
	
	boolean isAnagram = true;
	String currentChar = EMPTY;
	a = a.replace(EMPTY, SPACE).toLowerCase();
	b = b.replace(EMPTY, SPACE).toLowerCase();
	
	while(!a.isEmpty() && !a.equals(EMPTY) && isAnagram) {
	    
	    currentChar = a.substring(0,1);

	    a = a.replace(currentChar, EMPTY);
	    b = b.replace(currentChar, EMPTY);
	    
	    isAnagram = a.length() == b.length();
	    
	}
	
	return isAnagram;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}