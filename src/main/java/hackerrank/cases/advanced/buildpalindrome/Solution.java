package hackerrank.cases.advanced.buildpalindrome;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// https://www.hackerrank.com/challenges/challenging-palindromes/problem
public class Solution {

    private static final String BLANK = "";
    private static final String NO_PALINDROME = "-1";

    @SuppressWarnings("unused")
    static String buildPalindrome(String a, String b) {

	int[] arrayA = Arrays.stream(a.split(BLANK)).mapToInt(str -> (int) str.charAt(0)).toArray();
	int[] arrayB = Arrays.stream(b.split(BLANK)).mapToInt(str -> (int) str.charAt(0)).toArray();
	int[] subA;
	int[] subB;
	int[] currentCandidate;
	int aLength = arrayA.length;
	int bLength = arrayB.length;
	int[] palindrome = { 0 };
	boolean isPalindrome = true;

	for (int aSubLength = 1; aSubLength < aLength; aSubLength++) {

	    for (int aSubInit = 0; aSubInit + aSubLength < aLength; aSubInit++) {

		subA = Arrays.copyOfRange(arrayA, aSubInit, aSubInit + aSubLength);

		for (int bSubLength = 1; bSubLength < bLength; bSubLength++) {

		    for (int bSubInit = 0; bSubInit + bSubLength < bLength; bSubInit++) {

			subB = Arrays.copyOfRange(arrayB, bSubInit, bSubInit + bSubLength);
			currentCandidate = IntStream.concat(Arrays.stream(subA), Arrays.stream(subB)).toArray();

			if (isPalindrome(currentCandidate)) {

			    palindrome = (currentCandidate.length > palindrome.length)
				    || (currentCandidate.length == palindrome.length
					    && Arrays.stream(currentCandidate).sum() < Arrays.stream(palindrome).sum())
						    ? currentCandidate
						    : palindrome;
			}

		    }

		}
	    }
	}

	return palindrome.length < 3 ? NO_PALINDROME
		: Arrays.stream(palindrome).mapToObj(n -> String.valueOf((char) n)).collect(Collectors.joining(BLANK));

    }

    private static boolean isPalindrome(int[] arrayMaybePalindrome) {

	int maybePalindromeLenght = arrayMaybePalindrome.length - 1;
	int i = 0;
	boolean isPalindrome = true;

	while (isPalindrome && i < maybePalindromeLenght) {

	    isPalindrome = arrayMaybePalindrome[i] == arrayMaybePalindrome[maybePalindromeLenght];

	    i++;
	    maybePalindromeLenght--;

	}

	return isPalindrome;
    }

//    private static int[] concatCharArrays(int[] a, int[] b) {
//	
//	int resultLenght = a.length + b.length;
//	int[] result = new char[resultLenght];
//	int i = 0;
//	
//	for(char c : a) {
//	    
//	    result[i] = c;
//	    i++;
//	    
//	}
//	for(char c : b) {
//	    
//	    result[i] = c;
//	    i++;
//	    
//	}
//	
//	return result;
//	
//    }

    static String buildPalindromeOld(String a, String b) {

	int aLength = a.length();
	int bLength = b.length();
	String subA = BLANK;
	String subB = BLANK;
	String palindrome = "-1";
	String currentCandidate = BLANK;

	for (int aSubLength = 1; aSubLength <= aLength; aSubLength++) {

	    for (int aSubInit = 0; aSubInit + aSubLength <= aLength; aSubInit++) {

		subA = a.substring(aSubInit, aSubInit + aSubLength);

		for (int bSubLength = 1; bSubLength <= bLength; bSubLength++) {

		    for (int bSubInit = 0; bSubInit + bSubLength <= bLength; bSubInit++) {

			subB = b.substring(bSubInit, bSubInit + bSubLength);
			currentCandidate = subA.concat(subB);

			palindrome = (isPalindromeOld(currentCandidate)
				&& currentCandidate.length() > palindrome.length())
				|| (isPalindromeOld(currentCandidate)
					&& currentCandidate.length() == palindrome.length()
					&& palindrome.compareTo(currentCandidate) < 0) ? currentCandidate : palindrome;

		    }

		}
	    }
	}
	System.out.println(palindrome);

	return palindrome;
    }

    private static boolean isPalindromeOld(String maybePalindrome) {

//	String maybePalindrome = maybePalindrome.replaceAll("[^\\w]", "");
//        StringBuilder stringBuilder = new StringBuilder(maybePalindrome);
	int[] arrayMaybePalindrome = Arrays.stream(maybePalindrome.split(BLANK)).mapToInt(str -> (int) str.charAt(0))
		.toArray();
	int maybePalindromeLenght = arrayMaybePalindrome.length - 1;
	boolean isPalindrome = true;
	int i = 0;

//        for(int i = 0; i < maybePalindromeLenght; i++) {
	while (isPalindrome && i < maybePalindromeLenght) {

	    isPalindrome = arrayMaybePalindrome[i] == arrayMaybePalindrome[maybePalindromeLenght];

	    i++;
	    maybePalindromeLenght--;

	}

	return isPalindrome;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//	String env = System.getenv("C:\\Users\\Administrador\\Documents\\rafael_jimenez_reina\\d.txt");
	BufferedWriter bufferedWriter = new BufferedWriter(
		new FileWriter("C:\\Users\\Administrador\\Documents\\rafael_jimenez_reina\\d.txt"));

	int t = Integer.parseInt(scanner.nextLine().trim());

	for (int tItr = 0; tItr < t; tItr++) {
	    String a = scanner.nextLine();

	    String b = scanner.nextLine();

	    String result = buildPalindrome(a, b);

	    bufferedWriter.write(result);
	    bufferedWriter.newLine();
	}

	bufferedWriter.close();
    }
}
