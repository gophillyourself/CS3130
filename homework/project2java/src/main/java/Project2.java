import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Project2 {


    public static void main(String[] args){
        selectionSort(genArray(1000, 1, 10000));
        List<Integer> array = genArray(11, 1, 20);
        System.out.println(array);
        System.out.println(insertionSort(array));
        System.out.println(bubbleSort(array));
        System.out.println(bubbleSortWithSwapCount(array));
        System.out.println(quickSort(array, 0, array.size()-1));
        System.out.println(mergeSort(array, 0, array.size()-1));
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
        for (int i = 1; i < size; i++) {
            Integer current = sorted.get(i);
            for (int j = 0; j < i; j++) {
                if(current < sorted.get(j)) {
                    sorted.add(j, current);
                    sorted.remove(i + 1);
                    break;
                }
            }
        }
        return sorted;
    }

    public static List<Integer> bubbleSort(List<Integer> array) {
        List<Integer> sorted = new ArrayList<>(array);
        int size = sorted.size();
        boolean arrayIsSorted = false;
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

    public static List<Integer> bubbleSortWithSwapCount(List<Integer> array) {
        List<Integer> sorted = new ArrayList<>(array);
        int size = sorted.size();
        int swaps = 0;
        int maxSwaps = size * (size - 1) / 2;
        while(swaps < maxSwaps) {
            for (int i = 0; i < size-1; i++) {
                if (sorted.get(i) >= sorted.get(i + 1)) {
                    swapElements(sorted, i, i + 1);
                    swaps++;
                }
            }
        }
        return sorted;
    }

    public static List<Integer> quickSort(List<Integer> array, Integer leftMost, Integer rightMost) {
        Integer pivot;
        if (leftMost < rightMost) {
            pivot = partition(array, leftMost, rightMost);
            quickSort(array, leftMost, pivot - 1);
            quickSort(array, pivot + 1, rightMost);
        }
        return array;
    }

    public static Integer partition(List<Integer> array, Integer leftMost, Integer rightMost) {
        Integer pivot = array.get(rightMost);
        Integer i = leftMost;
        for (int j = leftMost; j <= rightMost - 1; j++) {
            Integer arrayJ = array.get(j);
            if (arrayJ < pivot) {
                if (i != j) {
                    swapElements(array, i, j);
                }
                i++;
            }
        }
        swapElements(array, i, rightMost);
        return i;
    }

    public static List<Integer> mergeSort(List<Integer> array, Integer leftMost, Integer rightMost) {
        Integer middle;
        if (leftMost < rightMost) {
            middle = (leftMost + rightMost) / 2;
            mergeSort(array, leftMost, middle);
            mergeSort(array, middle + 1, rightMost);
            merge(array, leftMost, middle, rightMost);
        }
        return array;
    }

    public static void merge(List<Integer> array, Integer leftMost, Integer middle, Integer rightMost) {
        final Integer LARGEST_INT = 2147483647;
        Integer n = middle - leftMost + 1;
        Integer m = rightMost - middle;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            leftArray.set(i, array.get(leftMost + i -1));
        }
        for (int i = 0; i < m; i++) {
            rightArray.set(i, array.get(middle+i));
        }
        leftArray.add(LARGEST_INT);
        rightArray.add(LARGEST_INT);
        Integer i = 0;
        Integer j = 0;
        for (int k = leftMost; k < rightMost; k++) {
            if (leftArray.get(i) < rightArray.get(j)) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
        }
    }

    private static void swapElements(List<Integer> array, Integer i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static List<Integer> genArray(Integer size, Integer min, Integer max) {
        ArrayList<Integer> unsortedArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unsortedArray.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return unsortedArray;
    }
}