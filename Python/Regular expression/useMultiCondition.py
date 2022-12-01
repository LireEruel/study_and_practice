import re

p1 = "apple"        # apple 포함하면 매치
p2 = "banana"       # banana 포함하면 매치

m1 = re.findall(p1, "I like apple and banana")
m2 = re.findall(p2, "I like apple and banana")

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)


### 아래 p3에 직접 정규표현식을 입력해보세요!

p3 = "apple|banana"             # apple 또는 banana가 포함되면 매치

m3 = re.findall(p3, "I like apple and banana")

print("m3 결과 : ", m3)

##[]을 사용하면 |을 사용하는 것보다 더 쉽게 활용할 수 있다! 후후

### 아래 p2과 p3에 직접 정규표현식을 입력해보세요.

p1 = "a|e|i|o|u"     # 알파벳 모음에 매치
p2 = "[aeiou]"     # 알파벳 모음에 매치
p3 = "[^aeiou]"     # 알파벳 모음이 아닌 문자(자음)에 매치

m1 = re.findall(p1, "Life is short, art is long")
m2 = re.findall(p2, "Life is short, art is long")
m3 = re.findall(p3, "Life is short, art is long")

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)
print("m3 결과 : ", m3)

### []와 -를 사용하면 조건을 범위로도 나타낼 수 있다

# 임의의 문자열입니다.
text = "vkvJZZjgsr=B5Al83+#@04?+p%x7DI3k"

p1 = "[0-9]"     # 숫자와 매칭됨
p2 = "[a-z]"     # 알파벳 소문자와 매칭됨

m1 = re.findall(p1, text)
m2 = re.findall(p2, text)

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)