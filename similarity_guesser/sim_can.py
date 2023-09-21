from gensim.models import KeyedVectors
import pandas as pd
import random

wv = KeyedVectors.load_word2vec_format("./toastynews.vec", binary=False)

pdFreq = pd.read_csv('Most Common Cantonese Words (Frequency List)_over 10.csv')
freqList = pdFreq['Word'].tolist()

answer = random.choice(freqList)
while(answer not in wv.key_to_index):
    answer = random.choice(freqList)

print(answer)
print(wv.most_similar(answer))
simList = []
for word in wv.key_to_index:
    tmp = [word, wv.similarity(answer, word)]
    simList.append(tmp)    
      
simList.sort(key=lambda l:l[1], reverse=True)
wordList = [simList[x][0] for x in range(len(simList))]

guess = input("請輸入字詞: ")
while(guess != answer):
    if(guess not in wv.key_to_index):
        print("搵唔到呢個字/詞語 :(")
    else:
        ranking = wordList.index(guess)
        print(f"你估咗: {guess}, 佢同答案嘅相似度爭{ranking}名")
    
    guess = input("請輸入字詞: ")

print(f"恭喜晒, 你估中咗啦! 個答案係: {answer}")