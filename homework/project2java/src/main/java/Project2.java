import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CS3130
 * Project 2
 * Phillip Janowski
 * Outputs time efficiencies of insertion sort, selection sort, two kinds of bubble sort,
 * quick sort, and merge sort in nano seconds
 */
public class Project2 {

    //global map that takes all the runtimes of the sorting algorithms.
    private static Map<String, Long> durations = new TreeMap<>();

    public static void durationGetter() {
        //generate initial unsorted arrays
        List<Integer> hundredIntegers = genArray(100, 1, 10000);
        List<Integer> thousandIntegers = genArray(1000, 1, 10000);
        List<Integer> tenThousandIntegers = genArray(10000, 1, 10000);
        //sort the arrays for testing of sorting methods of sorted arrays
        List<Integer> sortedHundred = insertionSort(hundredIntegers);
        List<Integer> sortedThousand = insertionSort(thousandIntegers);
        List<Integer> sortedTenThousand = insertionSort(tenThousandIntegers);
        //replace swaps every 9th and 10th array element of a sorted array.
        List<Integer> semiSortedHundred = semiSort(sortedHundred);
        List<Integer> semiSortedThousand = semiSort(sortedThousand);
        List<Integer> semiSortedTenThousand = semiSort(sortedTenThousand);

        //runners for each sorting method, adds the durations and testing params to a global map
        insertionSortDuration(hundredIntegers, thousandIntegers, tenThousandIntegers, 
                sortedHundred, sortedThousand, sortedTenThousand, 
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

        selectionSortDuration(hundredIntegers, thousandIntegers, tenThousandIntegers,
                sortedHundred, sortedThousand, sortedTenThousand,
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

        bubbleSortDurations(hundredIntegers, thousandIntegers, tenThousandIntegers,
                sortedHundred, sortedThousand, sortedTenThousand,
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

        bubbleSortWithSwapCountDurations(hundredIntegers, thousandIntegers,  tenThousandIntegers,
                sortedHundred, sortedThousand, sortedTenThousand,
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

        quickSortDurations(hundredIntegers, thousandIntegers,  tenThousandIntegers,
                sortedHundred, sortedThousand, sortedTenThousand,
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

        mergeSortDurations(hundredIntegers, thousandIntegers,  tenThousandIntegers,
                sortedHundred, sortedThousand, sortedTenThousand,
                semiSortedHundred, semiSortedThousand, semiSortedTenThousand);

    }

    public static void main(String[] args){
        durationGetter();
        //output as a csv for easier importing into excel
        //uses nano second precision because millis was too small to comparre, usually coming out to 0
        //put all the duration into a map to make it easier to handle and organize
        String durationsPrettyPrint = durations.toString()
                .replace(",", "\n")
                .replace("=", ",");
        System.out.println("Project 2 Output");
        System.out.println("[Sorting Algorithm] [Array Paramater Infor],[Running time in nanoseconds]");
        System.out.println(durationsPrettyPrint);
    }

    private static void mergeSortDurations(List<Integer> hundredIntegers,
                                           List<Integer> thousandIntegers,
                                           List<Integer> tenThousandIntegers,
                                           List<Integer> sortedHundred,
                                           List<Integer> sortedThousand,
                                           List<Integer> sortedTenThousand,
                                           List<Integer> semiSortedHundred,
                                           List<Integer> semiSortedThousand,
                                           List<Integer> semiSortedTenThousand) {
        long startTime;
        long endTime;
        long duration;//mergeSort
        startTime = System.nanoTime();
        //convert the lists to arrays because i could only get this method working for primitive arrays
        mergeSort(hundredIntegers.toArray(new Integer[0]), 0, hundredIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Hundred Integers", duration);

        startTime = System.nanoTime();
        mergeSort(thousandIntegers.toArray(new Integer[0]), 0, thousandIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Thousand Integers", duration);

        startTime = System.nanoTime();
        mergeSort(tenThousandIntegers.toArray(new Integer[0]), 0, tenThousandIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        mergeSort(sortedHundred.toArray(new Integer[0]), 0, sortedHundred.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        mergeSort(sortedThousand.toArray(new Integer[0]), 0, sortedThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        mergeSort(sortedTenThousand.toArray(new Integer[0]), 0, sortedTenThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        mergeSort(semiSortedHundred.toArray(new Integer[0]), 0, semiSortedHundred.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        mergeSort(semiSortedThousand.toArray(new Integer[0]), 0, semiSortedThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        mergeSort(semiSortedTenThousand.toArray(new Integer[0]), 0, semiSortedTenThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Merge Sort Ten Thousand semiSorted Integers", duration);
    }


    private static void quickSortDurations(List<Integer> hundredIntegers,
                                            List<Integer> thousandIntegers,
                                            List<Integer> tenThousandIntegers,
                                            List<Integer> sortedHundred,
                                            List<Integer> sortedThousand,
                                            List<Integer> sortedTenThousand,
                                            List<Integer> semiSortedHundred,
                                            List<Integer> semiSortedThousand,
                                            List<Integer> semiSortedTenThousand) {
        long startTime;
        long endTime;
        long duration;//quickSort
        startTime = System.nanoTime();
        quickSort(hundredIntegers, 0, hundredIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Hundred Integers", duration);

        startTime = System.nanoTime();
        quickSort(thousandIntegers, 0, thousandIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Thousand Integers", duration);

        startTime = System.nanoTime();
        quickSort(tenThousandIntegers, 0, tenThousandIntegers.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        quickSort(sortedHundred, 0, sortedHundred.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        quickSort(sortedThousand, 0, sortedThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        quickSort(sortedTenThousand, 0, sortedTenThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        quickSort(semiSortedHundred, 0, semiSortedHundred.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        quickSort(semiSortedThousand, 0, semiSortedThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        quickSort(semiSortedTenThousand, 0, semiSortedTenThousand.size() - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Quick Sort Ten Thousand semiSorted Integers", duration);
    }
    
    private static void bubbleSortDurations(List<Integer> hundredIntegers, 
                                            List<Integer> thousandIntegers, 
                                            List<Integer> tenThousandIntegers, 
                                            List<Integer> sortedHundred, 
                                            List<Integer> sortedThousand, 
                                            List<Integer> sortedTenThousand, 
                                            List<Integer> semiSortedHundred, 
                                            List<Integer> semiSortedThousand, 
                                            List<Integer> semiSortedTenThousand) {
        long startTime;
        long endTime;
        long duration;//bubbleSort
        startTime = System.nanoTime();
        bubbleSort(hundredIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Hundred Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(thousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Thousand Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(tenThousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(sortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(sortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(sortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(semiSortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(semiSortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSort(semiSortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort Ten Thousand semiSorted Integers", duration);
    }

    private static void bubbleSortWithSwapCountDurations(List<Integer> hundredIntegers, 
                                                         List<Integer> thousandIntegers, 
                                                         List<Integer> tenThousandIntegers, 
                                                         List<Integer> sortedHundred, 
                                                         List<Integer> sortedThousand, 
                                                         List<Integer> sortedTenThousand, 
                                                         List<Integer> semiSortedHundred, 
                                                         List<Integer> semiSortedThousand, 
                                                         List<Integer> semiSortedTenThousand) {
        long startTime;
        long endTime;
        long duration;//bubbleSortWithSwapCount
        startTime = System.nanoTime();
        bubbleSortWithSwapCount(hundredIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Hundred Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(thousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Thousand Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(tenThousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(sortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(sortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(sortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(semiSortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(semiSortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        bubbleSortWithSwapCount(semiSortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Bubble Sort with Swap Count Ten Thousand semiSorted Integers", duration);
    }
    private static void selectionSortDuration(List<Integer> hundredIntegers,
                                              List<Integer> thousandIntegers,
                                              List<Integer> tenThousandIntegers,
                                              List<Integer> sortedHundred,
                                              List<Integer> sortedThousand,
                                              List<Integer> sortedTenThousand,
                                              List<Integer> semiSortedHundred,
                                              List<Integer> semiSortedThousand,
                                              List<Integer> semiSortedTenThousand) {
        long startTime = System.nanoTime();
        selectionSort(hundredIntegers);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        durations.put("Selection Sort One Hundred Integers", duration);

        startTime = System.nanoTime();
        selectionSort(thousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort One Thousand Integers", duration);

        startTime = System.nanoTime();
        selectionSort(tenThousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        selectionSort(sortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        selectionSort(sortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        selectionSort(sortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        selectionSort(semiSortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        selectionSort(semiSortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        selectionSort(semiSortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Selection Sort Ten Thousand semiSorted Integers", duration);
    }
    
    
    private static void insertionSortDuration(List<Integer> hundredIntegers, 
                                              List<Integer> thousandIntegers, 
                                              List<Integer> tenThousandIntegers, 
                                              List<Integer> sortedHundred, 
                                              List<Integer> sortedThousand, 
                                              List<Integer> sortedTenThousand, 
                                              List<Integer> semiSortedHundred, 
                                              List<Integer> semiSortedThousand, 
                                              List<Integer> semiSortedTenThousand) {
        long startTime = System.nanoTime();
        insertionSort(hundredIntegers);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        durations.put("Insertion Sort One Hundred Integers", duration);

        startTime = System.nanoTime();
        insertionSort(thousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort One Thousand Integers", duration);

        startTime = System.nanoTime();
        insertionSort(tenThousandIntegers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort Ten Thousand Integers", duration);

        startTime = System.nanoTime();
        insertionSort(sortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort One Hundred Sorted Integers", duration);

        startTime = System.nanoTime();
        insertionSort(sortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort One Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        insertionSort(sortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort Ten Thousand Sorted Integers", duration);

        startTime = System.nanoTime();
        insertionSort(semiSortedHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort One Hundred semiSorted Integers", duration);

        startTime = System.nanoTime();
        insertionSort(semiSortedThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort One Thousand semiSorted Integers", duration);

        startTime = System.nanoTime();
        insertionSort(semiSortedTenThousand);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        durations.put("Insertion Sort Ten Thousand semiSorted Integers", duration);
    }

    public static List<Integer> selectionSort(List<Integer> array) {
        List<Integer> sorted = new ArrayList(array);
        int size = sorted.size();
        for (int i = 0; i < size; i++) {
            Integer smallest = sorted.get(i);
            Integer smallestElement = i;
            for (int j = i; j < size; j++) {
                if (smallest > sorted.get(j)) {
                    smallest = sorted.get(j);
                    smallestElement = j;
                }
            }
            //swap smallest with current index
            Integer temp = sorted.get(i);
            sorted.set(i, smallest);
            sorted.set(smallestElement, temp);
        }
        return sorted;
    }

    public static List<Integer> insertionSort(List<Integer> array) {
        List<Integer> sorted = new ArrayList(array);
        int size = sorted.size();
        //loop over every element starting with the second so theres an element to insert before
        //if it isn't the lowest number
        for (int i = 1; i < size; i++) {
            Integer current = sorted.get(i);
            for (int j = 0; j < i; j++) {
                if(current < sorted.get(j)) {
                    //insert and shift
                    sorted.add(j, current);
                    sorted.remove(i + 1);
                    break;
                }
            }
        }
        return sorted;
    }

    public static List<Integer> bubbleSortWithSwapCount(List<Integer> array) {
        List<Integer> sorted = new ArrayList<>(array);
        int size = sorted.size();
        boolean arrayIsSorted = false;
        //only exit if no elements were swapped
        while(!arrayIsSorted) {
            arrayIsSorted = true;
            for (int i = 0; i < size-1; i++) {
                if (sorted.get(i) >= sorted.get(i + 1)) {
                    if(sorted.get(i) > sorted.get(i + 1)) {
                        arrayIsSorted = false;
                    }
                    swapElements(sorted, i, i + 1);
                }
            }
        }
        return sorted;
    }

    public static List<Integer> bubbleSort(List<Integer> array) {
        List<Integer> sorted = new ArrayList<>(array);
        int size = sorted.size();
        //loop over every element
        for (int i = 0; i < size - 1; i++) {
            //loop over every element that we know is not sorted
            for (int j = 0; j < size - i - 1; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    swapElements(sorted, j, j + 1);
                }
            }
        }
        return sorted;
    }

    public static List<Integer> quickSort(List<Integer> array, Integer leftMost, Integer rightMost) {
        Integer pivot;
        if (leftMost < rightMost) {
            //find the next pivot from the last call to partition
            pivot = partition(array, leftMost, rightMost);
            quickSort(array, leftMost, pivot - 1);
            quickSort(array, pivot + 1, rightMost);
        }
        return array;
    }

    public static Integer partition(List<Integer> array, Integer leftMost, Integer rightMost) {
        Integer pivot = array.get(rightMost);
        Integer i = leftMost;
        //begin swapping elements into order
        for (int j = leftMost; j <= rightMost - 1; j++) {
            Integer arrayJ = array.get(j);
            if (arrayJ < pivot) {
                if (i != j) {
                    //swap elements in the partition if i is less than j and not the same
                    swapElements(array, i, j);
                }
                i++;
            }
        }
        swapElements(array, i, rightMost);
        return i;
    }

    public static Integer[] mergeSort(Integer[] array, Integer leftMost, Integer rightMost) {
        if (leftMost < rightMost) {
            //get the middle pivot element
            Integer middle = (leftMost+rightMost)/2;

            mergeSort(array, leftMost, middle);
            mergeSort(array , middle+1, rightMost);

            merge(array, leftMost, middle, rightMost);
        }
        return array;
    }

    public static void merge(Integer array[], Integer leftMost, Integer middle, Integer rightMost) {
        //Calulates the two inner bounds of the array to be split into left and right arrays
        Integer n1 = middle - leftMost + 1;
        Integer n2 = rightMost - middle;

        //creates the left and right arrays based on n1 and n2
        Integer leftArray[] = new Integer [n1];
        Integer rightArray[] = new Integer [n2];

        //constructs each sub array
        for (Integer i=0; i<n1; ++i) {
            leftArray[i] = array[leftMost + i];
        }

        for (Integer j=0; j<n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        Integer i = 0;
        Integer j = 0;

        Integer k = leftMost;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Swaps array elements i and j
     * @param array
     * @param i
     * @param j
     */
    private static void swapElements(List<Integer> array, Integer i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /**
     * Generates an array
     * @param size the size of the array
     * @param min the smallest possible number in the array
     * @param max the largest possible number in the array
     * @return Random list of array
     */
    public static List<Integer> genArray(Integer size, Integer min, Integer max) {
        ArrayList<Integer> unsortedArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unsortedArray.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return unsortedArray;
    }

    public static List<Integer> semiSort(List<Integer> sorted) {
        List<Integer> semiSorted = new ArrayList<>(sorted);
        //starting with the 10th element, swap the 9th and 10th elements
        for (int i = 9; i < semiSorted.size(); i++) {
            if(i % 9 == 0) {
                Integer temp = semiSorted.get(i);
                semiSorted.set(i, sorted.get(i-1));
                semiSorted.set(i-1, temp);
            }
        }
        return semiSorted;
    }
}