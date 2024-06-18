import random
from itertools import product
import itertools

# cách tính lấy 4 lá khác ký tự trong bộ bài  13C1*13C1*13C1*13C1 chia cho lấy  4 lá trong một bộ bài : 52C4 ta có 13C1*13C1*13C1*13C1/ 52C4=0.10549819927971188


def simualtor_poker1(n):
    sum = 0
    Ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K'}
    Suits = {'♡', '♢', '♣', '♠'}
    Cards = list(product(Ranks, Suits))
    poker_4 = list(itertools.combinations(Cards, 4))
    random.shuffle(poker_4)
    taken_list = list(poker_4[:n])
    # for i in range(n):
    #     # taken = list(random.sample(Cards, 4))
    #     taken = random.choice(poker_4)
    #     taken_list.append(taken)
    #     poker_4.remove(taken)
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
    return sum / n


print(simualtor_poker1(100))
print(simualtor_poker1(2000))
