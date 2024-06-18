from fractions import Fraction
import itertools


def P(event, space):
    '''The probability of an event , given a sample space of
   equiprobable outcomes.'''
    return Fraction(len(event & space), len(space))


E = {'M', 'F'}
S = list(itertools.product(E, repeat=3))
B = {s for s in S if 'F' in s}
A = {s for s in S if s.count('F') == 3}
A_B = {s for s in B if s.count('F') == 3}
print("(b) Determine the number of elements in the probability space S.")
print(len(S))
print('(c) Let B is the event that there is at least one female cat. List the elements of B and save to variable B.')
print(B)
print("Let A is the event that all three cats are female. List elements of event A and save to variable A.")
print(A)
print("Calculate the probability that all three cats are female under the condition that at least one cat is a female.")
print(P(A_B, B))
