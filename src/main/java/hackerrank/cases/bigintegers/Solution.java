package hackerrank.cases.bigintegers;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	
 public static void main(String[] args) {
	 
        Scanner in = new Scanner(System.in);
        
        BigInteger bigInteger1 = new BigInteger(in.next());
        BigInteger bigInteger2 = new BigInteger(in.next());
        
        System.out.println(bigInteger1.add(bigInteger2) + "\n" + bigInteger1.multiply(bigInteger2));

   }
}

// https://www.hackerrank.com/challenges/java-biginteger/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign