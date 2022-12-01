import re

text = "ct cat caat caaat caaaaat caaaaaat cbt c1t c@t c_t"

p1 = "ca*t"         # c와 t 사이에 'a'가 0개 이상 있는 경우 매칭

m1 = re.findall(p1, text)

print("m1 결과 : ", m1)


text = "apple banana carrot rabbit"

p1 = "[a-z]"        # 영어 소문자 매칭
p2 = "[a-z]+"       #1개 이상      # 영단어 단위로 매칭

m1 = re.findall(p1, text)
m2 = re.findall(p2, text)

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)

text = "2 96 4019 884863 56635574 946482 95325201 410505 5802 6661337 2937786 31103"

p1 = "\d{7,}"         # 자릿수가 7 이상인 수

m1 = re.findall(p1, text)

print("m1 결과 : ", m1)

