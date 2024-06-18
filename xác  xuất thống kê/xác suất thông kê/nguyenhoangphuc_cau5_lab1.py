import itertools
from re import I
count = 0


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


# note T is ten == 10
urn = cross('♠', '123456789TJQK') | cross('♣', '123456789TJQK') | cross(
    '♦', '123456789TJQK') | cross('♥', '123456789TJQK')
poker_5 = list(itertools.combinations(urn, 5))
three_of_a_kind = list()
len_poker_5 = len(poker_5)
print(len_poker_5)

"""for s in poker_5:
    for i in range(0, len(s)-1):
        count = s[i][1].count(s[i][1])
        if (count == 1):
            print(s)
        if (count == 1):
            add = list(s)
            three_of_a_kind = three_of_a_kind + add """

for s in poker_5:
    for i in range(0, len(s)-1):
        for j in range(i, len(s)-1):
            if (s[i][1] == s[j][1]):
                count = count + 1
        if (count == 3):
            print(s)
            add = list(s)
            three_of_a_kind1 = three_of_a_kind1 + add
            break
        count = 0
print(len(three_of_a_kind1))
