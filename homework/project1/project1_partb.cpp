#include <iostream>
#include <chrono>
#include "fibonnaci.h"

double counter = 0;
double nth = 0;

using namespace std;
using namespace std::chrono;

int main(int argc, char** argv) {
    string arg = argv[1];
    nth = stod(argv[1]);
    cout<<"Iterative fibonacci"<<endl;
    cout<<"Fibonacci Number"<<nth<<endl;
    cout<<" = "<<fibIter(nth)<<endl;
    return 0;
}

