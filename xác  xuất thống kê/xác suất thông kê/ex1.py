import random
from enum import Enum

CARDS_TO_TAKE = 5


class CardSuit(Enum):
    CLUBS = 1,
    DIAMONDS = 2,
    HEARTS = 3,
    SPADES = 4


print("Generating a card deck ...")
deck = []
for suit in CardSuit:
    deck.extend([suit] * 13)
print(f"Checking deck size: {len(deck)}")

random.shuffle(deck)
print("Card deck shuffled.")

print(f"Taking {CARDS_TO_TAKE} cards from the top:")
print([x.name for x in deck[:CARDS_TO_TAKE]])
