import itertools
from unittest import result

count = 0
number = 0


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


urn = cross('M', '1234') | cross(
    'P', '123') | cross('C', '12') | cross('L', '1')
print(urn)
result = list()
U6 = list(itertools.permutations(urn, 10))
for s in U6:
    for i in range(0, len(s)-1):
        if (s[i][0] != s[i+1][0]):
            count = count + 1
    if (count == 3):
        print(s)
        number = number + 1
    count = 0
print(number)
