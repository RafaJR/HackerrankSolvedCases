package hackerrank.cases.outputformat2;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("================================");
		for(int i=0;i<3;i++) {
			String str = sc.next();
          int n = sc.nextInt();
			float nf = 12.4534f;
                
			System.out.printf("%1$-15s%2$03d%n", str, n);
		}
		System.out.println("================================");

    }
}