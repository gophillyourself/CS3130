#include <iostream>
#include <time.h>
#include <stdlib.h>
#include <chrono>
#include <functional>

using namespace std;

const int LOWER_BOUND = 1;
const int UPPER_BOUND = 10000;

int hundredArray[100] = {0};
int thousandArray[1000] = {0};
int sortedHundredArray[100] = {0};
int tenThousandArray[100000] = {0};
int sortedThousandArray[1000] = {0};
int sortedTenThousandArray[100000] = {0};

void selectionSort();
void insertionSort();
void bubbleSort();
void bubbleSortSwapcount();
void quickSort();
void mergSort();
void genArray(int array[], int array2[]);
int getRandomNumber();
void resetArrays();

int main(int argc, char const *argv[])
{
    srand(time(NULL));
    genArray(hundredArray);
    genArray(thousandArray);
    genArray(tenThousandArray);

    auto start = std::chrono::high_resolution_clock::now();
    selectionSort();
    auto finish = std::chrono::high_resolution_clock::now();
    long duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    start = std::chrono::high_resolution_clock::now();
    insertionSort();
    finish = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    start = std::chrono::high_resolution_clock::now();
    bubbleSort();
    finish = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    start = std::chrono::high_resolution_clock::now();
    bubbleSortSwapcount();
    finish = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    start = std::chrono::high_resolution_clock::now();
    quickSort();
    finish = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    start = std::chrono::high_resolution_clock::now();
    mergSort();
    finish = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    resetArrays();

    return 0;
}

void selectionSort() {

}

void genArray(int array[], int array2[]) {
    for (int i = 0; i < sizeof(hundredArray); ++i) {
        int number = getRandomNumber();
        array[i] = number;
        array2[2] = number;
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