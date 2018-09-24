#include <iostream>
#include <chrono>
#include "fibonnaci.h"

double counter = 0;
double nth = 0;

using namespace std;
using namespace std::chrono;

void fibArrayRec(int n, int minus1[], int minus2[]);
void copyArray(int copyFrom[], int copyTo[]);
void printArray(int array[]);

int main(int argc, char** argv) {
    string arg = argv[1];
    nth = stod(argv[1]);

    int minus1[100] = {0};
    minus1[99] = 1;
    int minus2[100] = {0};
    
    cout<<nth<<endl;
    fibArrayRec(nth, minus1, minus2);
    for(int i = 0; i < 99; i++) {
        cout<<minus1[i]<<endl;
    }
}

void fibArrayRec(int n, int minus1[], int minus2[]) {
    if(n > 2) {
        fibArrayRec(n-1, minus1, minus2);
    } else {
        bool carryOver = false; 
        int tempMinus1[100] = {0};
        for(int i = 99; minus1[i] == NULL || minus2[i] == NULL; i--) {
            cout<<"forloop"<<endl;
            copyArray(minus1, tempMinus1);
            //adding, carrying and null terminating the arrays
            int sum = minus1[i] + minus2[i];
            cout<<"sum = "<<sum<<endl;
            carryOver = sum > 9;
            if(carryOver) {
                sum = sum - 10;
                minus1[i] = sum;
                if(minus1[i-1] == NULL){
                    minus1[i-1] = 1;
                    minus1[i-2] = NULL;
                } else {
                    minus1[i-1] = minus1[i-1] + 1;
                }
            } else {
                minus1[i] = sum;
            }
            minus2 = tempMinus1;
            cout<<"tempMinus1 = ";
            printArray(tempMinus1);
            cout<<endl;
            cout<<"minus 2 = ";
            printArray(minus2);
            cout<<endl;
        }
    }
}

void copyArray(int copyFrom[], int copyTo[]) {
    for(int i = 0; i < sizeof(copyFrom) && i < sizeof(copyTo); i++) {
        copyTo[i] = copyFrom[i];
    }
    cout<<"copied "<<endl;
    printArray(copyFrom);
    cout<<"to "<<endl;
    printArray(copyTo);
}

void printArray(int array[]) {
    for(int j = 0; j < sizeof(array); j++) {
        cout<<array[j];
    }
    cout<<endl;
}