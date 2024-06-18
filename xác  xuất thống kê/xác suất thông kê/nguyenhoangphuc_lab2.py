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

# Write a simulator function of rolling two dices n times. Calculate the experi-
# mental probability of the event that both dices are even.

# 9/36 +9/36 = 0.5


def simualtor_dice2(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if ((die1 % 2 == 0) and (die2 % 2 != 0)) or ((die1 % 2 != 0) and (die2 % 2 == 0)):
            count += 1
    return count/n

#6/36 


def simualtor_dice3(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == die2):
            count += 1
    return count/n

#2/36 


def simualtor_dice4(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == 1 and die2 == 6) or (die1 == 6 and die2 == 1):
            count += 1
    return count/n

# 
def simualtor_dice5(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 + die2 > 6):
            count += 1
    return count/n

# print(simualtor_dice1(1000000))
print(simualtor_dice2(1000000))
print(simualtor_dice3(1000))
# print(simualtor_dice4(1000000))
# print(simualtor_dice5(1000000))
