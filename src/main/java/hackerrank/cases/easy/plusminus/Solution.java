// https://www.hackerrank.com/challenges/plus-minus/problem?h_r=next-challenge&h_v=zen&isFullScreen=true

package hackerrank.cases.easy.plusminus;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    	
    	double listSize = Double.valueOf(arr.size());
    	
    	double possitiveRatio = arr.stream().filter(n -> n.intValue() > 0).count() / listSize;
    	double negativeRatio = arr.stream().filter(n -> n.intValue() < 0).count() / listSize;    	
    	double zeroRatio = arr.stream().filter(n -> n.equals(0)).count() / listSize;
    	
    	System.out.println(String.format("%.6f\n%.6f\n%.6f\n",possitiveRatio,negativeRatio,zeroRatio));
    	
    	

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}