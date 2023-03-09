package hackerrank.cases.medium.tagcontentextractor;
// https://www.hackerrank.com/challenges/tag-content-extractor/problem

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution{

	private static final Pattern tagPattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
	private static final String noValidTags = "None\n";
	
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
			Matcher tagMatcher = tagPattern.matcher(line);
			boolean anyMatch = false;
			
			while(tagMatcher.find()) {
//				System.out.println(tagMatcher.group(0) + " - " + tagMatcher.group(1) + " - " + tagMatcher.group(2));
				System.out.println(tagMatcher.group(2));
				anyMatch = true;
			}
			
			System.out.print(anyMatch ? "" : noValidTags);
			
			testCases--;
		}
	}
}