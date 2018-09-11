#include <iostream>
#include <chrono>
#include "fibonnaci.h"

double counter = 0;
double nth = 0;

using namespace std;
using namespace std::chrono;

int main() {
    cout<<"Fibonacci to the nth term"<<endl;
    while(nth <= 0) {
        cout<<"Nth = ";
        cin>>nth;
        if( nth<= 0) {
            cout<<"The nth term must be greater than 0"<<endl;
        } 
    }
    counter = 1;
    high_resolution_clock::time_point rect1 = high_resolution_clock::now();
    double fibRecOutput = fibRec(1,0);
    high_resolution_clock::time_point rect2 = high_resolution_clock::now();
    auto fibRecDuration = duration_cast<microseconds>( rect2 - rect1 ).count();

    high_resolution_clock::time_point itert1 = high_resolution_clock::now();
    double fibIterOutput = fibIter();
    high_resolution_clock::time_point itert2 = high_resolution_clock::now();
    auto fibIterDuration = duration_cast<microseconds>( itert2 - itert1 ).count();

    cout<<"fibRec = "<<fibRecOutput<<" fibRecDuration = "<<fibRecDuration<<endl;
    cout<<"fibIt = "<<fibIterOutput<<" fibIterDuration = "<<fibIterDuration<<endl;
    return 0;
}

