package hackerrank.cases.eof;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int count = 1;
    	StringBuffer stringBuffer = new StringBuffer();
    	
    	while(sc.hasNext()) {
    		
    		stringBuffer.append(count + " " + sc.nextLine() + "\n");
    		count++;    		
    	}
    	
    	System.out.println(stringBuffer.toString().trim());
    }
}
