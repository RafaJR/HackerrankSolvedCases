package hackerrank.cases.scanneruseexample.loopcalc;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] mult = {1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        Arrays.stream(mult).forEach(m -> System.out.printf("%1$d x %2$d = %3$d%n", N, m, N*m));
        scanner.close();
        
    }
    
}

//2 x 1 = 2
//2 x 2 = 4
//2 x 3 = 6
//2 x 4 = 8
//2 x 5 = 10
//2 x 6 = 12
//2 x 7 = 14
//2 x 8 = 16
//2 x 9 = 18
//2 x 10 = 20kj