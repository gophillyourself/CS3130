import sys

n = input('n: ')

whileLoopCount = 0
forLoop1 = 0
forLoop2 = 0

i = 0
while i < 3*n:
    whileLoopCount += 1
    i = i + 3


for i in xrange(n):
    for i in xrange(n):
        forLoop1 += 1

for i in xrange(n):
    for j in range(i,n):
        forLoop2 += 1

print("while loop " + str(whileLoopCount))
print("forloop1 " + str(forLoop1))
print("forloop2 " + str(forLoop2))