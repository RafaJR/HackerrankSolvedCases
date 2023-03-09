package hackerrank.cases.palindrome;

import java.util.Scanner;

public class Solution {
	
	private static final String YES = "Yes";
	private static final String NO = "No";

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.nextLine();
        
        String aNoSpaces = A.replaceAll("[^\\w]", "");
        StringBuilder stringBuilder = new StringBuilder(aNoSpaces);
        
        System.out.println(aNoSpaces.equalsIgnoreCase(stringBuilder.reverse().toString()) ? YES : NO);   
        
    }
    
}