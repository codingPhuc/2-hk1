from itertools import product
import itertools
import random
from tracemalloc import take_snapshot


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


# count = 0
# sum = 0
# Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
# Suits = {'♡', '♢', '♣', '♠'}
# Cards = list(product(Ranks, Suits))
# print(len(Cards))
# print(Cards)
# poker_5 = list(itertools.combinations(Cards, 5))
# print(len(poker_5))
# for s in poker_5:
#     count = 0
#     for i in range(0, len(s)):
#         if (s[i].count('♡')):
#             count = count + 1
#     if (count == 5):
#         sum = sum + 1
# print(sum)
# 13C5/52C5  = 33/6640
def simualtor_poker1(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_5 = list(itertools.combinations(Cards, 5))
    random.shuffle(poker_5)
    taken_list = list(poker_5[:n])
    # for i in range(n):
    #     # taken = list(random.sample(Cards, 4))
    #     taken = random.choice(poker_5)
    #     taken_list.append(taken)
    #     poker_5.remove(taken)
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i].count('♡')):
                count = count + 1
        if (count == 5):
            print(s)
            sum = sum + 1
    return sum/n


print(simualtor_poker1(1000000))
