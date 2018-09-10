#include <iostream>
#include <chrono>

double counter = 0;
double nth = 0;

using namespace std;
using namespace std::chrono;

int fibRec(int current, int last);
int fibIter();

int main() {
    cout<<"Fibonacci to the nth term"<<endl;
    cout<<"Nth = ";
    cin>>nth; 
    counter = 1;
    high_resolution_clock::time_point rect1 = high_resolution_clock::now();
    int fibRecOutput = fibRec(1,0);
    high_resolution_clock::time_point rect2 = high_resolution_clock::now();
    auto fibRecDuration = duration_cast<microseconds>( rect2 - rect1 ).count();

    high_resolution_clock::time_point itert1 = high_resolution_clock::now();
    int fibIterOutput = fibIter();
    high_resolution_clock::time_point itert2 = high_resolution_clock::now();
    auto fibIterDuration = duration_cast<microseconds>( itert2 - itert1 ).count();

    cout<<"fibRec = "<<fibRecOutput<<" fibRecDuration = "<<fibRecDuration<<endl;
    cout<<"fibIt = "<<fibIterOutput<<" fibIterDuration = "<<fibIterDuration<<endl;
    return 0;
}

int fibRec(int current, int last) {
    if(counter == nth) {
        return current;
    }
    counter++;
    return fibRec(current + last, current);
}

int fibIter() {
    counter = 1;
    int current = 1;
    int last = 0;
    int temp = 0;
    while(counter != nth) {
        temp = current;
        current = current + last;
        last = temp;
        counter++;
    }
    return current;
}
