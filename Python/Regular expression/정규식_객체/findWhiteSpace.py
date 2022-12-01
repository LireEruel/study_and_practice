import re


p1 = "\s"         # 공백 문자와 매칭
p2 = "\S"         # 공백이 아닌 문자와 매칭

m1 = re.findall(p1, "Life is short")
m2 = re.findall(p2, "Life is short")

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)