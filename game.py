#something to write about

def isWordGuessed(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: boolean, True if all the letters of secretWord are in lettersGuessed;
      False otherwise
    '''
    # FILL IN YOUR CODE HERE...
    length = len(secretWord)
    count = 0
    for e in lettersGuessed:
        if e in secretWord:
            count += 1
    return count == lengthṣ




def getGuessedWord(secretWord, lettersGuessed):
    # initializing display list
    list = ['_']*len(secretWord)
    correct = []
    # to make 'correct' list having characters which are in secretword
    for e in lettersGuessed:
        if e in secretWord:
            correct.append(e)
    # to detect index of 'correct' characters in secretwords and substitute
    # according values in 'list'
    for l in correct:
        index = 0
        for e in secretWord:
            if l == e:
                list[index] = l
                print(l)
            index += 1
    return ' '.join(list)


def getAvailableLetters(lettersGuessed):
    '''
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters that represents what letters have not
      yet been guessed.
    '''
    # FILL IN YOUR CODE HERE...
    alpha = string.ascii_lowercase
    s = ''
    for e in alpha:
        if e not in lettersGuessed:
            s += e
    return s


def hangman(secretWord):
    '''
        a game where we check whether users input is in secretWord or not
        user have 8 wrong chances to guess before he lose
    '''
    # Guessed is an array for user inputs
    Guessed = []
    counter = 8
    print("Welcome to the game, Hangman!")
    print("I am thinking of a word that is %i letters long." % len(secretWord))
    print("-------------")
    while counter > 0:
        # function to check whether user guessed the whole word correctly
        if isWordGuessed(secretWord, Guessed):
            print("Congratulations, you won!")
            return 0
        print("You have %i guesses left" % counter)
        print("Available letters: %s" % getAvailableLetters(Guessed))
        # user input
        new = input("Please guess a letter: ").lower()
        while True:
            # if user repeats a char which he already used before
            if new in Guessed:
                print("Oops! You've already guessed that letter: %s" % getGuessedWord(secretWord, Guessed))
                break
            else:
                # updating user guess array
                Guessed.append(new)
            if new in secretWord:
                print("Good guess: %s" % getGuessedWord(secretWord, Guessed))
                break
            else:
                # each wrong guess will reduce the number of chances
                print("Oops! That letter is not in my word: %s" % getGuessedWord(secretWord, Guessed))
                counter -= 1
                break
        print("-------------")
    # if user runs out of chances and still don't guess the word
    print("Sorry, you ran out of guesses. The word was %s" % secretWord)
    return None


import string
import random
from ps3_hangman import loadWords, chooseWord

wordlist = loadWords()
secretWord = random.choice(wordlist)
print(secretWord)
hangman(secretWord)

