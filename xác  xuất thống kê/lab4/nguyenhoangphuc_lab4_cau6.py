from itertools import count, permutations
import itertools
from os import remove


def convertTuple(tup):
    str = ''.join(tup)
    return str


E = {0, 1, 2, 3, 4, 5}
diff = list(itertools.permutations(E, 4))
mylist = list(dict.fromkeys(diff))
not_diff = [''.join(map(str, itertools.product(E, repeat=3)))]
not_diff = list(itertools.product(E, repeat=3))
# print(not_diff)
# res = ''.join(map(str, not_diff[0]))
# print(not_diff)
diff = list(itertools.permutations(E, 4))
unpacking_tuple = [num for num in diff if num[0] != 0]

Str_list = [int(''.join(map(str, n))) for n in unpacking_tuple]
print("all the way to create 4 digit number pairwise different")
for n in Str_list:
    print(n)
unpacking_tuple = [num for num in not_diff if num[0] != 0]
print("all the way to create 3 digit number ")
Str_list = [int(''.join(map(str, n))) for n in unpacking_tuple]
for n in Str_list:
    print(n)
