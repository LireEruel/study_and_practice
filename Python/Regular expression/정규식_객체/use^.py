import re

'''
아래에 정규표현식을 직접 입력해보세요!
'''

p1 = "^Life"         # Life로 시작해야 매치
p2 = "^is"         # is로 시작해야 매치

m1 = re.findall(p1, "Life is short")
m2 = re.findall(p2, "Life is short")

print("m1 결과 : ", m1) # ['Life']
print("m2 결과 : ", m2) # []

# Life is short는 Life로 시작하기 때문에 m1은 결과가 있지만 m2는 없다.