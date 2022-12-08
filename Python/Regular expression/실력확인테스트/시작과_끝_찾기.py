
import re

s = input()

p1 = "^\w\d{4}.$"    # 여기에 정규표현식을 입력하세요.

m1 = re.search(p1, s) is not None

print(m1)