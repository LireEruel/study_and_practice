import re

text = "tomato"

p1 = "(to)ma\\1"             # 그룹 참조

m1 = re.search(p1, text)

print("m1 결과 : ", m1.group()) # tomato
