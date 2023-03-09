package hackerrank.cases.easy.diagonaldifference;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test1() {
					
		List<List<Integer>> testSquare1 = new ArrayList<List<Integer>>();
		List<Integer> listInteger1 = Stream.of(1,2,3).collect(Collectors.toList());
		List<Integer> listInteger2 = Stream.of(4,5,7).collect(Collectors.toList());
		List<Integer> listInteger3 = Stream.of(7,8,9).collect(Collectors.toList());
		testSquare1.add(listInteger1);
		testSquare1.add(listInteger2);
		testSquare1.add(listInteger3);
		
		int result = Result.diagonalDifference(testSquare1);
		
		assertEquals(0, result);
	}

}
