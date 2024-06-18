import random
#6/36 chọn 1 lần duy nhất


def simualtor_dice3(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == die2):
            count += 1
    return count/n