package hackerrank.cases.easy.minimumdistances;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    public void minimumDistancesTest1() {

        assertEquals(2, Result.minimumDistances(Stream.of(3, 2, 1, 2, 3, 15, 23).collect(Collectors.toList())));

    }
    @Test
    public void minimumDistancesTest2() {

        assertEquals(-1, Result.minimumDistances(Stream.of(1,2,3,4,5).collect(Collectors.toList())));

    }
    @Test
    public void minimumDistancesTest3() {

        assertEquals(3, Result.minimumDistances(Stream.of(1,2,3,4,5,6,3,7,8,9,10,8).collect(Collectors.toList())));

    }

}