#include <iostream>
#include <chrono>
#include <string>
#include "fibonnaci.h"

double counter = 0;
double nth = 0;

using namespace std;
using namespace std::chrono;

int main(int argc, char** argv) {
    string arg = argv[1];
    nth = stod(argv[1]);
    cout<<"Recursive fibonacci"<<endl;
    cout<<"Fibonacci Number "<<nth<<endl;
    cout<<" = "<<fib(nth)<<endl;
    return 0;
}