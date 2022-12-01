import re
text = "catatatatatat"

p1 = "cat"
p2 = "c(at)+"    # c뒤에 at가 1번 이상 반복         # 정규식 패턴 입력!

m1 = re.search(p1, text)
m2 = re.search(p2, text)

print("m1 결과 : ", m1.group())
print("m2 결과 : ", m2.group())