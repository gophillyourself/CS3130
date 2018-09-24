#include <iostream>
#include <chrono>
#include "fibonnaci.h"
#include <sys/time.h>

long double nth = 0;

using namespace std;
using namespace std::chrono;

int main(int argc, char** argv) {
    string arg = argv[1];
    nth = stod(argv[1]);

    std::chrono::time_point<std::chrono::system_clock> now = std::chrono::system_clock::now();

    cout<<"Fibonacci to the "<<nth<<" term"<<endl;
    auto start = std::chrono::high_resolution_clock::now();
    long double fibRecOutput = fib(nth);
    auto finish = std::chrono::high_resolution_clock::now();
    long double fibRecDuration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish-start).count();

    start = std::chrono::high_resolution_clock::now();
    long double fibIterOutput = fibIter(nth);
    finish = std::chrono::high_resolution_clock::now();
    long double fibIterDuration = std::chrono::duration_cast<std::chrono::nanoseconds>(finish-start).count();

    cout<<"fibRec = "<<fibRecOutput<<" fibRecDuration (nanoseconds) = "<<fibRecDuration<<endl;
    cout<<"fibIt = "<<fibIterOutput<<" fibIterDuration (nanoseconds)= "<<fibIterDuration<<endl;
    return 0;
}

