package hackerrank.cases.stringssimplecase;

import java.util.Scanner;

public class Solution {

public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(capitalizeSting(A).concat(" ").concat(capitalizeSting(B)));
    }
    private static String capitalizeSting(String str) {
    
        return str.substring(0,1).toUpperCase().concat(str.substring(1, str.length()));
    
    }
}