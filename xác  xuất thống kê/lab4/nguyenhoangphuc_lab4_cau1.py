import random
# 6/36 chọn 1 lần duy nhất


def simualtor_dice1(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == die2):
            count += 1
    return count/n


def simualtor_dice3(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 % 2 == 0 and die2 % 2 == 0):
            count += 1
    return count/n


def simualtor_dice2(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 != die2):
            count += 1
    return count/n


def simualtor_dice4(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 % 2 != 0 and die2 % 2 != 0):
            count += 1
    return count/n


def simualtor_dice5(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if ((die1 % 2 != 0 and die2 % 2 == 0) or (die1 % 2 == 0 and die2 % 2 != 0)):
            count += 1
    return count/n


def simualtor_dice6(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == 6 and die2 == 6):
            count += 1
    return count/n


def simualtor_dice7(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 + die2 > 10):
            count += 1
    return count/n


print(simualtor_dice1(1000))
print(simualtor_dice2(1000))
print(simualtor_dice3(1000))
print(simualtor_dice4(1000))
print(simualtor_dice5(1000))
print(simualtor_dice6(1000))
print(simualtor_dice7(1000))
