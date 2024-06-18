import itertools
from unittest import result

count = 0
number = 0


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


Nwoman = 0
Nman = 0
urn = cross('M', '123456') | cross('W', '123456789')
print(urn)
result = list()
U5 = list(itertools.combinations(urn, 5))
for s in U5:
    for i in range(0, len(s)):
        if (s[i][0] == 'M'):
            Nman = Nman + 1
        else:
            Nwoman = Nwoman + 1
    if (Nman == 3 and Nwoman == 2):
        print(s)
    Nwoman = 0
    Nman = 0
