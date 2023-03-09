//https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true

package hackerrank.cases.easy.diagonaldifference;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    	
    	int rightDiagonalSum = calculateDiagonalSum(arr, true);
    	int leftDiagonalSum = calculateDiagonalSum(arr, false);
    	
    	int result = rightDiagonalSum - leftDiagonalSum;
    	
    	result = result >= 0 ? result : result * -1;
    	
    	return result;

    }
    
    public static int calculateDiagonalSum(List<List<Integer>> arr, boolean rightSense) {
    	
    	int i = rightSense ? 0 : arr.stream().findFirst().get().size() - 1;
    	int indexAdd = rightSense ? 1 : -1;
    	
    	int sum = 0;
    	
    	for(List<Integer> currentList : arr) {
    		
    		sum += currentList.get(i);
    		i += indexAdd;
    	}
    	
    	return sum;
    	
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
