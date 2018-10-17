
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Project2Test {
    private static List<Integer> unsorted;

    @BeforeAll
    public static void setUp() {
        unsorted = Project2.genArray(10000, 1, 10000);
        System.out.println(unsorted);
    }

    @Test
    public void selectionSortTest() {
        List<Integer> sorted = Project2.selectionSort(unsorted);
        checkSorted(sorted);
        checkContaining(sorted, unsorted);

        //just to make sure they aren't getting deep copied when getting sorted
        //if they did the check containing would be pointless
        assertTrue(!sorted.equals(unsorted));
        System.out.println(sorted);
    }

    @Test
    public void insertAndShiftTest() {
        List<Integer> sorted = Project2.insertionSort(unsorted);
        checkSorted(sorted);
        checkContaining(sorted, unsorted);

        //just to make sure they aren't getting deep copied when getting sorted
        //if they did the check containing would be pointless
        assertTrue(!sorted.equals(unsorted));
        System.out.println(sorted);
    }

    @Test
    public void bubbleSort() {
        List<Integer> sorted = Project2.bubbleSort(unsorted);
        checkSorted(sorted);
        checkContaining(sorted, unsorted);

        //just to make sure they aren't getting deep copied when getting sorted
        //if they did the check containing would be pointless
        assertTrue(!sorted.equals(unsorted));
        System.out.println(sorted);
    }

    private void checkSorted(List<Integer> sorted) {
        for (int i = 0; i < sorted.size() -1; i++) {
            assertTrue(sorted.get(i) <= sorted.get(i+1),
                    sorted.get(i) + " "+"not > " + sorted.get(i+1) + " i: " + i);
        }
    }

    private void checkContaining(List<Integer> sorted, List<Integer> unsorted) {
        Map<Integer, Long> unsortedMapResult = unsorted.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> sortedMapResult = sorted.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Integer integer : unsortedMapResult.keySet()) {
            assertTrue(sortedMapResult.keySet().contains(integer));
            assertTrue(sortedMapResult.get(integer).equals(unsortedMapResult.get(integer)));
        }
    }
}