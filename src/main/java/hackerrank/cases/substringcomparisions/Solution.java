package hackerrank.cases.substringcomparisions;

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
	
	String smallest = s;
        String largest = "";
        String subStr = "";
        
        int sLenght = s.length();
        
        for(int i = 0; i <= sLenght -k; i++) {
            
            subStr = s.substring(i, i + k);
            smallest = smallest.compareTo(subStr) < 0 ? smallest : subStr;
            largest = largest.compareTo(subStr) > 0 ? largest : subStr;
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
