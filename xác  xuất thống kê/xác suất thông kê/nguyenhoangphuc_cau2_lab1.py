import itertools
from pickle import TRUE
count = 0


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


urn = cross('W', '12345678') | cross('B', '123456') | cross(
    'R', '123456789')
print(urn)

U3 = list(itertools.combinations(urn, 3))
print(len(U3))
print("all of them are different ball ")
for s in U3:
    if (s[0][0] != s[1][0] and s[0][0] != s[2][0] and s[1][0] != s[2][0]):
        print(s)
        count = count + 1
print(count)
count = 0
print("the first ball red  and the last ball white ")
for s in U3:
    for s in U3:
        if s[0][0] == 'W' and s[-1][0] == 'R':
            print(s)
            count = count + 1
print(count)
