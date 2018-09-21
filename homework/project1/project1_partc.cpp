#include <iostream>
#include <chrono>
#include "fibonnaci.h"
#include <sys/time.h>

double nth = 0;

using namespace std;
using namespace std::chrono;

int main(int argc, char** argv) {
    string arg = argv[1];
    nth = stod(argv[1]);

    cout<<"Fibonacci to the "<<nth<<" term"<<endl;
    high_resolution_clock::time_point rect1 = chrono::system_clock::now();
    double fibRecOutput = fib(nth);
    high_resolution_clock::time_point rect2 = chrono::system_clock::now();
    auto fibRecDuration = duration_cast<microseconds>( rect2 - rect1 ).count();

    high_resolution_clock::time_point itert1 = chrono::system_clock::now();
    double fibIterOutput = fibIter(nth);
    high_resolution_clock::time_point itert2 = chrono::system_clock::now();
    auto fibIterDuration = duration_cast<microseconds>( itert2 - itert1 ).count();

    // cout<<"fibRec = "<<fibRecOutput<<" fibRecDuration = "<<fibRecDuration<<endl;
    cout<<"fibIt = "<<fibIterOutput<<" fibIterDuration = "<<fibIterDuration<<endl;
    return 0;
}

