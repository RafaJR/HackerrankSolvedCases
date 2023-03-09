package hackerrank.cases.arrayhourglass;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

	int[][] arr = new int[6][6];

	for (int i = 0; i < 6; i++) {
	    String[] arrRowItems = scanner.nextLine().split(" ");
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int j = 0; j < 6; j++) {
		int arrItem = Integer.parseInt(arrRowItems[j]);
		arr[i][j] = arrItem;
	    }
	}

	scanner.close();

	System.out.println(getMajorHourGlass(arr));
    }

    private static int getMajorHourGlass(int[][] inputArray) {

	int lastIndex = 3;
	int avant = 2;
	int acum = 0;
	int result = Integer.MIN_VALUE;
	int currentIndex = 0;

	for (int i = 0; i <= lastIndex; i++) {
	    for (int j = 0; j <= lastIndex; j++) {
		currentIndex = j + lastIndex;
		acum = Arrays.stream(Arrays.copyOfRange(inputArray[i], j, currentIndex)).sum()
			+ inputArray[i + 1][j + 1]
			+ Arrays.stream(Arrays.copyOfRange(inputArray[i + avant], j, currentIndex)).sum();
		result = acum > result ? acum : result;

	    }

	}

	return result;

    }
}