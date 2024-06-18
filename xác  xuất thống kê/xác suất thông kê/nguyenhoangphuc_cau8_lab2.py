import random
from itertools import count, product
import itertools


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}

# lấy 2 lần mỗi màu 6C2* 9C2 * 8C2 chia cho trường hợp lấy 6 viên 52C6 => 6C2* 9C2 * 8C2/52C6 =0.1497815685458706


def simualtor_poker1():
    sum = 0
    urn = cross('B', '123456') | cross(
        'W', '12345678') | cross('R', '123456789')
    U6 = list(itertools.combinations(urn, 6))
    for s in U6:
        count_white = 0
        count_red = 0
        count_bule = 0
        for i in range(0, len(s)):
            if (s[i].count('B')):
                count_bule = count_bule + 1
            if (s[i].count('W')):
                count_white = count_white + 1
            if (s[i].count('R')):
                count_red = count_red + 1
        if (count_red == 2 and count_bule == 2 and count_white == 2):
            sum = sum + 1
    return sum / len(U6)


print(simualtor_poker1())
