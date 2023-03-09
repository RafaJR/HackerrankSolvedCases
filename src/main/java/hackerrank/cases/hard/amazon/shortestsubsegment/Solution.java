package hackerrank.cases.hard.amazon.shortestsubsegment;
// https://www.hackerrank.com/challenges/sorted-subsegments/problem

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	
	private static final String SPACE = " ";
	private static final String BLANK = "";
	private static final String NOT_FOUND = "NO SUBSEGMENT FOUND";

    public static void main(String[] args) {
    	
    	
    	
    	// Parameters input
    	Scanner in = new Scanner(System.in);
    	String text = SPACE + in.nextLine().replaceAll("[^\\w\\s]", BLANK) + SPACE;
    	int nWords = in.nextInt();
    	String[] words = new String[nWords];
    	for(int i = 0; i < nWords; i++) {
    		words[i] = in.next();
    	}
    	
    	String regex = buildRegex(words);    	
    	Matcher matcher = Pattern.compile(regex).matcher(text);
    	String result = new String(text + SPACE);
    	String currentMatch = BLANK;
    	boolean anyMatch = false;

    	while(matcher.find()) {
    		
    		anyMatch = true;
    		currentMatch = matcher.group().trim();
    		result = !currentMatch.equals(BLANK) && result.length() > currentMatch.length() ? currentMatch : result;
//    		System.out.println(result);
    	}
    	
    	System.out.println(anyMatch ? result.replace(BLANK, "empty") : NOT_FOUND);
    }
    
    private static String buildRegex(String[] words) {
    	
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("/^");
    	
    	Arrays.stream(words).forEach(word -> {
//    		stringBuffer.append("(?=[" + word + "\\s])");
    		stringBuffer.append("(?=.*\\b" + word + "\\b)");
//    		/^(?=.*\bword1\b)(?=.*\bword2\b)(?=.*\bword3\b).*$/m
    	});
    	stringBuffer.append(".*$//m");
    	
    	return stringBuffer.toString();
    }
    
}
// This is a test. This is a programming test. This is a programming test in any language.
// 4
// a
// test
// this
// program

// This is a test. This is a programming test. This is a programming test in any language.
// 4
// this
// a
// test
// programming

// aaa bbb bb ddd ccc ddd d eee fff ffff ggg hhh iii jjj
