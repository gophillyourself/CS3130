#include <iostream>
#include "fibonnaci.h"

using namespace std;

long double fib(long double n) {
    if(n <= 2) {
        return 1;
    } else {
        return fib(n-1) + fib(n-2);
    }
}

long double fibIter(long double nth) {
    double counter = 1;
    long double current = 1;
    long double last = 0;
    long double temp = 0;
    while(counter != nth) {
        temp = current;
        current = current + last;
        last = temp;
        counter++;
    }
    return current;
}