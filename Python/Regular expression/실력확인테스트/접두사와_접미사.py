import re

p1 = "^ex\D*"         # ex로 시작해야 매치
p2 = "\D*ful$"         # ful로 끝나야 매치


words = ["flexible", "carefully", "chocolate", "expand", "exclude", "wonderful", "helpful"]

result1 = []
result2 = []

for word in words :
    # 단어들을 검사하여 리스트에 넣는 코드입니다. 수정하지 않아도 됩니다.
    m1 = re.findall(p1, word)
    m2 = re.findall(p2, word)
    
    result1 += m1
    result2 += m2
    
print("ex로 시작하는 단어 : ", result1)
print("ful로 끝나는 단어 : ", result2)