package hackerrank.cases.restapiassessment.totalgoals;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @SneakyThrows
    @Test
    public void getTotalGoalsTest1() {

        assertEquals(35, Result.getTotalGoals("Barcelona", 2011));

    }

}