import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	
	@Test
	public void mergeTest() {
		String input = "[25,30] [2,19] [14,23] [4,8]";
		List <Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 2);
		assertEquals(result.get(0).getStartZeit(), 2);
		assertEquals(result.get(0).getEndZeit(), 23);
		assertEquals(result.get(1).getStartZeit(), 25);
		assertEquals(result.get(1).getEndZeit(), 30);
		
		
		
		
	}
	
	@Test
	public void mergeTestEmptyInput() {
		String input = "";
		List<Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 0);
	}

	@Test
	public void mergeTestSameInput() {
		String input = "[25,30] [25,30]";
		List<Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getStartZeit(), 25);
		assertEquals(result.get(0).getEndZeit(), 30);
	}
	
	@Test
	public void mergeTestCloseInput() {
		String input = "[25,31] [24,30]";
		List<Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getStartZeit(), 24);
		assertEquals(result.get(0).getEndZeit(), 31);
	}
	
	@Test
	public void mergeTestSingleInput() {
		String input = "[25,30]";
		List<Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getStartZeit(), 25);
		assertEquals(result.get(0).getEndZeit(), 30);
	}
	
	@Test
	public void mergeTestNegativeInput() {
		String input = "[-25,30] [-24,37]";
		List<Intervall> listIntervalle = Solution.handleInput(input);
		List<Intervall> result = Solution.merge(listIntervalle);
		
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getStartZeit(), -25);
		assertEquals(result.get(0).getEndZeit(), 37);
	}
}
