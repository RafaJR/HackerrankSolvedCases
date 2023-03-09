package hackerrank.cases.tokens;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    
    private static final String REGEX = "[^a-zA-Z0-9]*[^a-zA-Z0-9]";
    private static final String JUMP = "\n";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        
        s = Arrays.stream(s.split(REGEX)).collect(Collectors.joining(JUMP)).trim();
        
        if(s.equals(EMPTY)) {
            
            System.out.printf("0");
            
        }else {
            
            System.out.printf("%d\n%s", s.split(JUMP).length, s);
        }
    }
}