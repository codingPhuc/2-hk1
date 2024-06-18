from distutils.errors import LibError
from itertools import product
import itertools
import random
from tracemalloc import take_snapshot

from nguyenhoangphuc_lab3_cau1 import A

sum = 0
Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
Suits = {'♡', '♢', '♣', '♠'}
Cards = list(product(Ranks, Suits))

B = list(itertools.combinations(Cards, 3))
A1 = list()
A2 = list()
print("A1 is the event that 3 cards include 1 or 2 K. Save the elements of event A1 to variable A1.")
for s in B:
    count = 0
    for i in range(0, len(s)):
        if (s[i].count('K')):
            count = count + 1
    if (count == 1 or count == 2):
        A1.append(s)
print(len(A1))
print("A2 is the event that 3 cards include at least 1 K. Save the elements of event A2 into variable A2.")
for s in B:
    count = 0
    for i in range(0, len(s)):
        if (s[i].count('K')):
            count = count + 1
    if (count > 0):
        A2.append(s)
print(len(A2))
print("Calculate the probability of two events A1 and A2. (Hint: P(A1) = 0.2172; P(A2) = 0.2174)")
P_A1 = round(len(A1)/len(B), 4)
P_A2 = round(len(A2)/len(B), 4)
print("the probability of A1 is " + str(P_A1) + " and A2 is " + str(P_A2))
