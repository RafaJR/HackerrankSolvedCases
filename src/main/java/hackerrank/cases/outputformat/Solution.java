package hackerrank.cases.outputformat;

import java.util.Scanner;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);
    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        
        System.out.println(!isEven(N) || isInRange(N, 6, 20) ? WEIRD 
        	: isInRange(N, 2, 5) || N > 20  ? NOT_WEIRD : WEIRD);
    }
    
    private static boolean isEven(int n) { // par
    	
    	return n % 2 == 0;
    }
    private static boolean isInRange(int n, int min, int max) {
    	
    	return min <= n && n <= max;
    }
}

//If
//is odd, print Weird
//If
//is even and in the inclusive range of to
//, print Not Weird
//If
//is even and in the inclusive range of to
//, print Weird
//If
//is even and greater than , print Not Weird
