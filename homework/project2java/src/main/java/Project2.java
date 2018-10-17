import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Project2 {


    public static void main(String[] args){
        selectionSort(genArray(1000, 1, 10000));
        List<Integer> array = genArray(10, 1, 20);
        System.out.println(array);
        System.out.println(insertionSort(array));
        System.out.println(bubbleSort(array));
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
                    Integer temp = sorted.get(i);
                    sorted.set(i, sorted.get(i + 1));
                    sorted.set(i + 1, temp);
                }
            }
        }
        return sorted;
    }

    public static List<Integer> genArray(Integer size, Integer min, Integer max) {
        ArrayList<Integer> unsortedArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unsortedArray.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return unsortedArray;
    }
}