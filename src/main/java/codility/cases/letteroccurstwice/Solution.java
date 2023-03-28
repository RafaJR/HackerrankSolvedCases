package codility.cases.letteroccurstwice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Solution {

    // Regular expression to find character that occurs twice in a String.
    private final String TWICE_CHAR_REGEX = "[a-z]*([a-z])[a-z]*\\1[a-z]*";
    public String solution(String S) {

        // 'Matcher' built using a 'Pattern' that compiles the 'regex' to find a repeated character
        final Matcher matcher = Pattern.compile(TWICE_CHAR_REGEX).matcher(S);

        // If any character occurs twice, it will be contained in the regex first group, so it will be returned.
        // Else, a null value will be returned.
        return matcher.find() ? matcher.group(1) : null;

    }
}
