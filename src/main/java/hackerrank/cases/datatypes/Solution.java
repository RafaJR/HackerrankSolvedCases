package hackerrank.cases.datatypes;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
	
	private static final String BYTE = "* byte";
	private static final String SHORT = "* short";
	private static final String INT = "* int";
	private static final String LONG = "* long";
//	private static final String FLOAT = "* float";
//	private static final String DOUBLE = "* double";
	
    public static void main(String []argh) {
    	
    	StringBuffer stringBuffer = new StringBuffer();
    	double[][] intervals = {
    			{Byte.MIN_VALUE, Byte.MAX_VALUE, 0},
    			{Short.MIN_VALUE, Short.MAX_VALUE, 1}, 
    			{Integer.MIN_VALUE, Integer.MAX_VALUE, 2}, 
    			{Long.MIN_VALUE, Long.MAX_VALUE, 3}, 
//    			{Float.MIN_VALUE, Float.MAX_VALUE, 4}, 
//    			{Double.MIN_VALUE, Double.MAX_VALUE, 5}
    	};
//    	String[] dataTypes = {BYTE, SHORT, INT, LONG, FLOAT, DOUBLE};
    	String[] dataTypes = {BYTE, SHORT, INT, LONG};
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
//        int t = 10;
        for(int i=0;i<t;i++) {      	

            try
            {
                long x=sc.nextLong();
//            	long x = 10000000;
            	stringBuffer.append(x + " can be fitted in:\n");
            	Arrays.stream(intervals).forEach(interval -> {
            		stringBuffer.append(x >= interval[0] && x <= interval[1] ? dataTypes[(int) interval[2]] + "\n" : "");
            	});
            }
            catch(Exception e)
            {
            	stringBuffer.append(sc.next()+" can't be fitted anywhere.\n");
            }
        }
        
        System.out.println(stringBuffer.toString());     
        
    }
}