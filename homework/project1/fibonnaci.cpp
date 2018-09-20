#include <iostream>
#include "fibonnaci.h"

using namespace std;

double fib(double n) {
    if(n <= 2) {
        return 1;
    } else {
        return fib(n-1) + fib(n-2);
    }
}

double fibIter(double nth) {
    int counter = 1;
    double current = 1;
    double last = 0;
    double temp = 0;
    while(counter != nth) {
        temp = current;
        current = current + last;
        last = temp;
        counter++;
    }
    return current;
}