import random
guesses = []
rand = random.randint(0,100)
while(True):
    guess=int(input("Guess the number (0-100): "))
    guesses.append(guess)
    if(rand==guess):
        print(f"Correct guess, the number is: {rand}")
        break
    elif(guess<rand):
        print("higher")
    else:
        print("lower")
print(f"guesses: {guesses}, attempts: {len(guesses)}")