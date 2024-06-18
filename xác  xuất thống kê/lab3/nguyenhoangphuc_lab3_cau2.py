from fractions import Fraction
import itertools
S = {('Thanh', 'Nữ'), ('Hồng', 'Nữ'), ('Thương', 'Nữ'), (' Đào', 'Nữ'), ('My', 'Nữ'), ('Yến', 'Nữ'), ('Hạnh', 'Nữ'), ('My', 'Nữ'), ('Vy', 'Nữ'),
     ('Tiên', 'Nữ'), ('Thanh', 'Nam'), ('Thanh', 'Nam'), ('Bình', 'Nam'), ('Nhật', 'Nam'), ('Hào', 'Nam'), ('Đạt', 'Nam'), ('Minh', 'Nam')}

B = {s for s in S if 'Nữ' in s}
A = {s for s in S if 'Thanh' in s}
A_B = {s for s in B if 'Thanh' in s}


def P(event, space):
    '''The probability of an event , given a sample space of
   equiprobable outcomes.'''
    return Fraction(len(event & space), len(space))


print("List elements of event A and store in variable A.")
print(A)
print("List the elements of event B and save to variable B.")
print(B)
print("List the elements of the event A ∩ B and store it in the variable A_B.")
print(A_B)
print("Calculate the probability of the three above events and stored in three variables P_A, P_B, P_A_B respectively.")
P_A = P(A, S)
P_B = P(A, S)
P_A_B = P(A_B, S)
P_A_withB = P(A_B, B)
print("Calculate the probability that the called student’s name is “Thanh” under the condition that “this is a female”.")
print(P_A_withB)
