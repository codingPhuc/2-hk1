from dis import code_info
import random

#  9/36=0.25


def simualtor_dice1(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 % 2 == 0) and (die2 % 2 == 0):
            count += 1
    return count/n
print(simualtor_dice1(100))