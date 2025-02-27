import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class PascalsTriangleTest {
    PascalsTriangle pascalsTriangle = new PascalsTriangle();
    @Test
    void testGenerateZeroRows() {
        List<List<Integer>> result = pascalsTriangle.generate(0);
        assertTrue(result.isEmpty(), "Expected empty list for 0 rows.");
    }
    @Test
    void testGenerateOneRow() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        assertEquals(expected, pascalsTriangle.generate(1), "Expected [[1]] for 1 row.");
    }
    @Test
    void testGenerateTwoRows() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1)
        );
        assertEquals(expected, pascalsTriangle.generate(2), "Expected [[1], [1,1]] for 2 rows.");
    }
    @Test
    void testGenerateFiveRows() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        );
        assertEquals(expected, pascalsTriangle.generate(5), "Expected Pascal's triangle for 5 rows.");
    }
    @Test
    void testGenerateNegativeRows() {
        List<List<Integer>> result = pascalsTriangle.generate(-3);
        assertTrue(result.isEmpty(), "Expected empty list for negative input.");
    }
}