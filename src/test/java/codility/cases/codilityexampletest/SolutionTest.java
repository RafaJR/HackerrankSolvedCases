package codility.cases.codilityexampletest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void solutionTest() {

        int[] input = {1,2,3};

        assertEquals(4, solution.solution(input));
    }

}