import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Project2Test {

    public void selectionSortTest() {
        List<Integer> unsorted = Project2.genArray(10000, 1, 10000);
        List<Integer> sorted = Project2.selectionSort(unsorted);
        checkSorted(sorted);
        System.out.println(unsorted);
        System.out.println(sorted);
    }

    private void checkSorted(List<Integer> sorted) {
        for (int i = 0; i < sorted.size() -1; i++) {
            assertTrue(sorted.get(i) <= sorted.get(i+1),
                    sorted.get(i) + " "+"not > " + sorted.get(i+1) + " i: " + i);
        }
    }
}