import itertools
from itertools import product
import random

from sympy import false


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


def simualtor_poker1(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i].count(s[0][1])):
                count = count + 1
        if (count == 4):
            sum = sum + 1
            print(s)
    return sum/n


# print(simualtor_poker1(1000000))


def simualtor_poker4(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i].count(s[0][0])):
                count = count + 1
        if (count == 4):
            sum = sum + 1
            print(s)
    return sum/n


# print(simualtor_poker4(10000000))


def simualtor_poker3(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count_red = 0
        count_white = 0
        for i in range(0, len(s)):
            if (s[i].count('♡') or [i].count('♢')):
                count_red = count_red+1
            if (s[i].count('♣') or s[i].count('♠')):
                count_white = count_white + 1
        if (count_red == 4 or count_white == 4):
            sum = sum + 1
    return sum/n


# print(simualtor_poker3(1000000))


def simualtor_poker2(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count_heart = 0
        count_diamond = 0
        count_club = 0
        count_spade = 0
        for i in range(0, len(s)):
            if (s[i].count('♡')):
                count_heart = count_heart + 1
            if (s[i].count('♢')):
                count_diamond = count_diamond + 1
            if (s[i].count('♣')):
                count_club = count_club + 1
            if (s[i].count('♠')):
                count_spade = count_spade + 1
        if (count_heart > 0 and count_diamond > 0 and count_club > 0 and count_spade):
            sum = sum + 1
    return sum/n


def simualtor_poker5(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i].count('J') or s[i].count('Q') or s[i].count('K')):
                count = count + 1
        if (count == 0):
            sum = sum + 1
            print(s)
    return sum/n


# print(simualtor_poker5(10000000))


def simualtor_poker6(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    print(len(Cards))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i].count('J') or s[i].count('Q') or s[i].count('K')):
                count = count + 1
        if (count == 4):
            sum = sum + 1
            print(s)
    return sum/n


# print(simualtor_poker6(10000000))
