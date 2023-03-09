package hackerrank.cases.scanneruseexample;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        
        String str = "";
        
        while(scan.hasNext()) {
        	
        	str = str.concat(scan.nextLine());
        	
        }

        // Write your code here.

        System.out.println("String: " + str);
        System.out.println("Double: " + String.valueOf(d).trim());
        System.out.println("Int: " + String.valueOf(i).trim());
        
    }
    
}


//The first line contains an integer. 
//The second line contains a double.
//The third line contains a String.
//
//
//On the first line, print String: followed by the unaltered String read from stdin.
//On the second line, print Double: followed by the unaltered double read from stdin.
//On the third line, print Int: followed by the unaltered integer read from stdin.
//2147483647
//
//235345345345.234534
//
//  fsdfsdf   sdf