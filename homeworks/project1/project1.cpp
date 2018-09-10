#include <iostream>

int counter = 0;
int nth = 0;

using namespace std;

int main() {
    cout<<"Fibonacci to the nth term"<<endl;
    cout<<"Nth = "<<endl;
    cin>>nth; 
    return 0;
}

int fib(int current, int last) {
    if(counter == nth) {
        return current;
    }
    counter++;
    return fib(current + last, current)
}

int fib() {
    return fib(1, 0);
}