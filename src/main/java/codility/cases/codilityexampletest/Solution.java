package codility.cases.codilityexampletest;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public int solution(int[] A) {

        int maxValue = IntStream.of(A).max().getAsInt();

        return maxValue <= 0 ? 1 : IntStream.range(1, maxValue + 2).filter(n -> !IntStream.of(A).anyMatch(a -> a == n)).findFirst().getAsInt();

    }
}
