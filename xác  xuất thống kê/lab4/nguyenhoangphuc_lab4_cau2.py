import itertools
import random


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


urn = cross('B', '12') | cross('R', '123') | cross('W', '12345')

URN = list(itertools.combinations(urn, 3))
# def Ball():
#     white1blue1red1 = list()
#     sum = 0
#     for s in URN:
#         count_W = 0
#         count_B = 0
#         count_R = 0

#         for i in range(0, len(s)):
#             if (s[i].count('W')):
#                 count_W = count_W + 1
#             if (s[i].count('R')):
#                 count_R = count_R + 1
#             if (s[i].count('B')):
#                 count_B = count_B + 1
#         if (count_W == 1 and count_B == 1 and count_R == 1):
#             white1blue1red1.append(s)
#     return white1blue1red1


def simulation_ball1(n):
    sum = 0
    urn = cross('B', '12') | cross('R', '123') | cross('W', '12345')

    Ball_3 = list(itertools.combinations(urn, 3))
    random.shuffle(Ball_3)
    taken_list = [random.choice(Ball_3) for n in range(n)]
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i][0] == s[0][0]):
                count = count + 1
        if (count == 3):
            sum = sum + 1
    return sum/n


def simulation_ball2(n):
    sum = 0
    urn = cross('B', '12') | cross('R', '123') | cross('W', '12345')

    Ball_3 = list(itertools.combinations(urn, 3))
    random.shuffle(Ball_3)
    taken_list = [random.choice(Ball_3) for n in range(n)]
    for s in taken_list:
        count = 0
        for i in range(0, len(s)):
            if (s[i][0] == s[0][0]):
                count = count + 1
        if (count == 3):
            sum = sum + 1
    return sum/n


def simulation_ball3(n):
    sum = 0
    urn = cross('B', '12') | cross('R', '123') | cross('W', '12345')

    Ball_3 = list(itertools.combinations(urn, 3))
    random.shuffle(Ball_3)
    taken_list = [random.choice(Ball_3) for n in range(n)]
    for s in taken_list:
        count_R = 0
        count_W = 0
        for i in range(0, len(s)):
            if (s[i].count('R')):
                count_R = count_R + 1
            if (s[i].count('W')):
                count_W = count_W + 1
        if (count_R == 2 and count_W == 1):
            print(s)
            sum = sum + 1
    return sum/n


def simulation_ball4(n):
    sum = 0
    urn = cross('B', '12') | cross('R', '123') | cross('W', '12345')

    Ball_3 = list(itertools.combinations(urn, 3))
    random.shuffle(Ball_3)
    taken_list = [random.choice(Ball_3) for n in range(n)]
    for s in taken_list:
        count_W = 0
        for i in range(0, len(s)):
            if (s[i].count('W')):
                count_W = count_W + 1
        if (count_W == 3):
            print(s)
            sum = sum + 1
    return sum/n


print(simulation_ball2(1000000))
print(simulation_ball2(1000000))
print(simulation_ball3(1000))
print(simulation_ball4(10000))
