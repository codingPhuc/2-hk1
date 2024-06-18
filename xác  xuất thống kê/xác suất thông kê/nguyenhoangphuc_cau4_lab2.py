import random
# 2/36 chọn hai viên bằng nhau


def simualtor_dice4(n):
    count = 0
    for simulation in range(n):
        die1 = random.randint(1, 6)
        die2 = random.randint(1, 6)
        if (die1 == 1 and die2 == 6) or (die1 == 6 and die2 == 1):
            count += 1
    return count/n
