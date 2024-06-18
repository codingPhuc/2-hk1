import random
#


def simualtor_dice5(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 + die2 > 6):
            count += 1
    return count/n
