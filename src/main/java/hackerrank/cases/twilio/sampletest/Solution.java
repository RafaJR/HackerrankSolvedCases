package hackerrank.cases.twilio.sampletest;

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
     * Complete the 'calcMissing' function below.
     *
     * The function accepts STRING_ARRAY readings as parameter.
     */

    public static void calcMissing(List<String> readings) {
    	
    	final String missingDataRegex = "Missing_";
    	final Pattern missingDataPattern = Pattern.compile("(.*?)(" + missingDataRegex + ")([\\d]{1,2})");
    	final String VOID = "";
    	
    	readings.stream().filter(missingDataPattern.asPredicate()).forEach(missingData -> {
    		
    		String missed = Arrays.stream(missingData.split("\t")).reduce((s1,s2) -> s2).get().replace(missingDataRegex, VOID);
//    		String missed = missingDataPattern.matcher(missingData).matches() ? missingDataPattern.matcher(missingData).group() : "";
    		
    		System.out.println(missed + ".23");
    	});

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int readingsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> readings = IntStream.range(0, readingsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.calcMissing(readings);

        bufferedReader.close();
    }
}
