import random
import copy
import unittest

UPPER_BOUND = 10000
LOWER_BOUND = 1

def selectionSort(array, printArrays):
    sortedArray  = copy.deepcopy(array)

    for i in range(0, len(sortedArray)):
        smallest = sortedArray[i]
        smallestElement = 0
        for j in range(i, len(sortedArray)):
            if sortedArray[j] < smallest:
                smallest = sortedArray[j]
                smallestElement = j
        temp = sortedArray[i]
        sortedArray[i] = smallest
        sortedArray[smallestElement] = temp
    if printArrays:
        print(array)
        print(sortedArray)
    return sortedArray

def insertionSort(array, printArray):
    sortedArray = copy.deepcopy(array)
    for i in range(1,len(sortedArray)):
         currentvalue = sortedArray[i]
         position = i
         while position>0 and sortedArray[position-1]>currentvalue:
             sortedArray[position]=array[position-1]
             position = position-1
         sortedArray[position]=currentvalue
    if printArray:
        print(array)
        print(sortedArray)


def genArray(size):
    array = [0] * size
    for i in range(0, size):
        array[i] = random.randint(LOWER_BOUND, UPPER_BOUND)
    return array


hundredArray = genArray(100)
thousandArray = genArray(1000)
tenThousandArray = genArray(100000)

# selectionSort(hundredArray, True)
# selectionSort(thousandArray, True)
selectionSort(tenThousandArray, True)

# insertionSort(hundredArray, True)
# insertionSort(thousandArray, True)
# insertionSort(tenThousandArray, True)


class TestSelectionSort(unittest.TestCase):
    def checkSorted(self, array):
        for i in range(0, len(array)-1):
            if array[i] > array[i+1]:
                return False

    def test_selectionSort(self):
        self.assertTrue(self.checkSorted(selectionSort(genArray(100), False)))
        self.assertTrue(self.checkSorted(selectionSort(genArray(1000), False)))
        self.assertTrue(self.checkSorted(selectionSort(genArray(10000), False)))
