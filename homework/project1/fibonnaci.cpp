#include <iostream>
#include "fibonnaci.h"
using namespace std;

double fibRec(double nth, double counter, double current, double last) {
    if(counter == nth) {
        return current;
    }
    counter++;
    return fibRec(nth, counter, current + last, current);
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