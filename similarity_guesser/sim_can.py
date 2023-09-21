from gensim.models import KeyedVectors
import pandas as pd
import random

wv_from_text = KeyedVectors.load_word2vec_format("./toastynews.vec", binary=False)
wv = wv_from_text

pdFreq = pd.read_csv('Most Common Cantonese Words (Frequency List)_over 10.csv')
freqList = pdFreq['Word'].tolist()

answer = random.choice(freqList)
while(answer not in wv.key_to_index):
    answer = random.choice(freqList)

print(answer)
print(wv.most_similar(answer))
wordList = []
simList = []
for word in wv.key_to_index:
    tmp = [word, wv.similarity(answer, word)]
    simList.append(tmp)    
      
simList.sort(key=lambda l:l[1], reverse=True)

guess = input("Enter a word: ")
while(guess != answer):
    if(guess not in wv.key_to_index):
        print("Not a valid word")
    else:
        ranking = 0
        for i in range(len(simList)):
            if guess == simList[i][0]:
                ranking = i+1
        print(f"Your guess is: {guess}, it's ranking in terms of similarity to the answer is {ranking}")
    
    guess = input("Enter a word: ")

print(f"Congrats, You've guessed it! The answer is {answer}")