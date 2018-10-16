#include <iostream>
#include <time.h>
#include <stdlib.h>
#include <chrono>
#include <functional>

using namespace std;
//constants
const int LOWER_BOUND = 1;
const int UPPER_BOUND = 10000;

//arrays
int hundredArray[100] = {0};
int thousandArray[1000] = {0};
int tenThousandArray[100000] = {0};

//arrays that will get sorted so i can save the other ones
//to be able to reset them for other sorts
int sortedHundredArray[100] = {0};
int sortedThousandArray[1000] = {0};
int sortedTenThousandArray[100000] = {0};

//sort algorithms
void selectionSort(int array[]);
void insertionSort(int array[]);
void bubbleSort(int array[]);
void bubbleSortSwapcount(int array[]);
void quickSort(int array[]);
void mergSort(int array[]);

//utilities
void genArray(int array[], int array2[]);
void printArray(int array[]);
int getRandomNumber();
void resetArrays();

int main(int argc, char const *argv[]) {
    srand(time(NULL));
    genArray(hundredArray, sortedHundredArray);
    genArray(thousandArray, sortedThousandArray);
    genArray(tenThousandArray, sortedTenThousandArray);

    auto start = std::chrono::high_resolution_clock::now();
    selectionSort(sortedHundredArray);
    auto finish = std::chrono::high_resolution_clock::now();
    long duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    printArray(sortedHundredArray);
    printArray(hundredArray);
    resetArrays();

//    start = std::chrono::high_resolution_clock::now();
//    insertionSort();
//    finish = std::chrono::high_resolution_clock::now();
//    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
//    resetArrays();
//
//    start = std::chrono::high_resolution_clock::now();
//    bubbleSort();
//    finish = std::chrono::high_resolution_clock::now();
//    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
//    resetArrays();
//
//    start = std::chrono::high_resolution_clock::now();
//    bubbleSortSwapcount();
//    finish = std::chrono::high_resolution_clock::now();
//    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
//    resetArrays();
//
//    start = std::chrono::high_resolution_clock::now();
//    quickSort();
//    finish = std::chrono::high_resolution_clock::now();
//    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
//    resetArrays();
//
//    start = std::chrono::high_resolution_clock::now();
//    mergSort();
//    finish = std::chrono::high_resolution_clock::now();
//    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
//    resetArrays();

    return 0;
}

void selectionSort(int array[]) {
    int sizeOfArray = sizeof(array);
    for (int i = 0; i < sizeOfArray; ++i) {
        int smallest = array[i];
        for(int j = i; j < sizeOfArray; ++j) {
            if(array[j] < smallest) {
                smallest = array[j];
            }
        }
        array[i] = smallest;
    }
}

void genArray(int array[], int array2[]) {
    for (int i = 0; i < sizeof(hundredArray); ++i) {
        int number = getRandomNumber();
        array[i] = number;
        array2[i] = number;
    }
}

int getRandomNumber() {
    return rand() & UPPER_BOUND + LOWER_BOUND;
}

void resetArrays() {
    for (int i = 0; i < sizeof(hundredArray); ++i) {
        sortedHundredArray[i] = hundredArray[i];
    }

    for (int i = 0; i < sizeof(hundredArray); ++i) {
        sortedThousandArray[i] = thousandArray[i];
    }

    for (int i = 0; i < sizeof(hundredArray); ++i) {
        sortedTenThousandArray[i] = tenThousandArray[i];
    }
}

void printArray(int array[]) {
    for (int i = 0; i < sizeof(array); ++i) {
        cout<<array[i]<<endl;
    }
}