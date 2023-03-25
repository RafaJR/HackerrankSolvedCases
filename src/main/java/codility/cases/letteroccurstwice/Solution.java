package codility.cases.letteroccurstwice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Solution {

    public String solution(String S) {

        // 'Matcher' defined using a 'Pattern' that is constructed from a regular expression designed to find a character that occurs twice in the string.
        Matcher matcher = Pattern.compile("[a-z]*([a-z])[a-z]*\\1[a-z]*").matcher(S);

        return matcher.find() ? matcher.group(1) : "";

    }
}
