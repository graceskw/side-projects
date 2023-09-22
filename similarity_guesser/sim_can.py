from gensim.models import KeyedVectors
import pandas as pd
import random

# get word2vec for Cantontese words
wv = KeyedVectors.load_word2vec_format("../toastynews.vec", binary=False)

# get frequency list of Cantonese words
pdFreq = pd.read_csv('Most Common Cantonese Words (Frequency List)_over 10.csv')
freqList = pdFreq['Word'].tolist()

# get random word from frequency list, regenerate if not in word2vec
answer = random.choice(freqList)
while(answer not in wv.key_to_index):
    answer = random.choice(freqList)

# for debug
print(answer)
print(wv.most_similar(answer))

# get similarity ranking of all words in word2vec in relation to answer
simList = []
for word in wv.key_to_index:
    tmp = [word, wv.similarity(answer, word)]
    simList.append(tmp)    

# sort similarity ranking in descending order
simList.sort(key=lambda l:l[1], reverse=True)
# get word list from sorted similarity ranking
wordList = [simList[x][0] for x in range(len(simList))]

# start guessing
guess = input("請輸入字詞: ")
while(guess != answer):
    # if guess not in word2vec, print error message
    if(guess not in wv.key_to_index):
        print("搵唔到呢個字/詞語 :(")
    else:
        # get similarity ranking of guess in relation to answer
        ranking = wordList.index(guess)
        print(f"你估咗: {guess}, 佢同答案嘅相似度爭{ranking}名")
    
    guess = input("請輸入字詞: ")

print(f"恭喜晒, 你估中咗啦! 個答案係: {answer}")