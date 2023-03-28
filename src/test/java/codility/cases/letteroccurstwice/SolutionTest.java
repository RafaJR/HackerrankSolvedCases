package codility.cases.letteroccurstwice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void solutionTest1() {

        String input = "aba";

        assertEquals("a", solution.solution(input));
    }
    @Test
    public void solutionTest2() {

        String input = "zz";

        assertEquals("z", solution.solution(input));
    }
    @Test
    public void solutionTest3() {

        String input = "codility";

        assertEquals("i", solution.solution(input));
    }
    @Test
    public void solutionTest4() {

        String input = "abcdefghijk";

        assertEquals(null, solution.solution(input));
    }
    @Test
    public void solutionTest5() {

        String input = "bacalao";

        assertEquals("a", solution.solution(input));
    }

    @Test
    public void solutionTest6() {

        String input = "11";

        assertEquals(null, solution.solution(input));
    }

}