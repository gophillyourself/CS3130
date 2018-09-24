import sys
import numpy
import copy

size = 100
minus1 = [0] * size
minus2 = [0] * size
total = [0] * size
minus1[size-1] = 2
minus2[size-1] = 1
count = 3
sumStr = '0'
while len(str(sumStr)) < size:
    count = count + 1
    total = [0] * size
    upperBound = size - len(numpy.trim_zeros(minus1))
    for i in range(size-1, 0, -1):
        minus_1_ = minus1[i]
        minus_2_ = minus2[i]
        sum = minus_1_ + minus_2_
        sumPlusTotal = sum + total[i]
        if sumPlusTotal >= 10:
            singles = sumPlusTotal - (int(str(sumPlusTotal)[:1]) * 10)
            total[i] = singles
            carried = total[i - 1] + int(str(sumPlusTotal+total[i-1])[:1])
            total[i-1] = carried
        else:
            total[i] = total[i] + sum
    for i in range(99, upperBound, -1):
        if total[i] >= 10:
            total[i] = int(str(total[i])[1])
            total[i-1] = total[i-1] + int(str(total[i])[0])

    minus2 = copy.deepcopy(minus1)
    minus1 = copy.deepcopy(total)
    trimmed = numpy.trim_zeros(total, 'f')
    sumStr = ''.join(str(e) for e in trimmed)
    print "fib " + str(count) + ": " + str(trimmed)
trimmed = numpy.trim_zeros(minus2, 'f')
sumStr = ''.join(str(e) for e in trimmed)
print sumStr + " is the " + str(count - 1) + " fibonacci number and the largest fibonacci number that is 100 digits long"

