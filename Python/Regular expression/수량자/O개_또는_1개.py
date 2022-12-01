import re

text = "ac abc abbc abbbc abbbbbc"

p1 = "ab?c"         # ac, abc와 매칭

m1 = re.findall(p1, text)

print("m1 결과 : ", m1)

#?를 수량자 뒤에 붙이면 가능한 한 최소한의 수량과 매칭되도록 한다.

text = "<html><head><Title>제목</head></html>"

p1 = "<.*>"
p2 = "<.*?>"         #정규표현식을 이용해보세요.

m1 = re.findall(p1, text)
m2 = re.findall(p2, text)

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)                

