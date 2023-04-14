// https://www.hackerrank.com/challenges/minimum-distances/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
package hackerrank.cases.easy.minimumdistances;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {

        if (!(a.stream().distinct().count() < a.size())) {
            return -1;
        } else {

            int result = Integer.MAX_VALUE;
            int inputLength = a.size();
            int currentDistance = 0;

            for (int i = 0; i < inputLength; i++) {

                for (int j = i + 1; j < inputLength; j++) {
                    if (a.get(i).equals(a.get(j))) {
                        currentDistance = j - i;
                        if (result > currentDistance) {
                            result = currentDistance;
                        }
                    }
                }
            }

            return result;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

