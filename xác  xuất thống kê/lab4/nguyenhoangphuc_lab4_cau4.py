import itertools
from re import S
from unittest import result

from sympy import principal_branch


def cross(A, B):
    '''The set of ways of concatenating one item from
    collection A with one from B.'''
    return {a + b for a in A for b in B}


print("a/ Create a set to save all the balls. Call the 2 white balls &#39;W1&#39; and &#39;W2&#39;.Similiarly, 3 blue balls are &#39;B1&#39;, &#39;B2&#39;, &#39;B3&#39; and 4 red balls are &#39;R1&#39;, &#39;R2&#39;, &#39;R3&#39;. Save them in a variable named URN.")
urn = cross('B', '123') | cross('R', '123') | cross('W', '12')
print(urn)
result = list()
print("b/ Find the subset of 3 balls from set URN (regardless the order). Save your result in variable U3.")
URN = list(itertools.combinations(urn, 3))
print(URN)


def Ball():
    white1blue1red1 = list()
    sum = 0
    for s in URN:
        count_W = 0
        count_B = 0
        count_R = 0

        for i in range(0, len(s)):
            if (s[i].count('W')):
                count_W = count_W + 1
            if (s[i].count('R')):
                count_R = count_R + 1
            if (s[i].count('B')):
                count_B = count_B + 1
        if (count_W == 1 and count_B == 1 and count_R == 1):
            white1blue1red1.append(s)
    return white1blue1red1


print("c/ List all the cases that 3 balls in question (b) including 1 white ball, 1 blue ball, and 1 red ball. Save your result in variable white1blue1red1.")
white1blue1red1 = Ball()
print(white1blue1red1)
print("d/ Find the probability that randomly choose 3 balls including 1 white ball, 1 blue ball, and 1 red ball. Save your result in variable P.")
P = len(white1blue1red1) / len(URN)
print("this is P", P)
