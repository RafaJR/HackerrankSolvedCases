package hackerrank.cases.medium.lilyshomework;
// https://www.hackerrank.com/challenges/lilys-homework/problem

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
    	
    	int[] sortedArr = Arrays.stream(arr).sorted().toArray();    	
    	
    	int swapCounter = 0;
    	int end = arr.length;
    	
    	for(int i = 0; i < end; i++) {
    		
    		swapCounter += arr[i] != sortedArr[i] ? 1 : 0;
    		
    	}
    	
    	return swapCounter -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.printf("Resultado: %1$d" , result);

        scanner.close();
    }
}