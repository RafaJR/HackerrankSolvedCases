package hackerrank.cases.scanneruseexample.multiply;

import java.util.Scanner;

class Solution {
	
	private static int CONSTANT = 2;
	
    public static void main(String []argh){
    	
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        
        for(int i=0;i<t;i++){
        	
    	    int a = in.nextInt();
    	    int b = in.nextInt();
    	    int n = in.nextInt();
    	    
    	    int current = a+b;
    	    System.out.print(current + " ");
    	    
        	for(int j = 1; j < n; j++) {
	            current = getNext(current, j, b);
	            System.out.print(current + " ");
        	}
        	
        	System.out.println();
            
        }
        
        in.close();
    }
    
    private static int getNext(int previous, int i, int b) {
    	
    	return previous + (int) Math.pow(CONSTANT, i) * b;
    }
}