import re

# potato, tomato두 단어를 보시면, 뒤에 세 글자 ato가 겹치는 것을 알 수 있습니다.

# 따라서 (pot|tom)ato 패턴은 tomato, potato두 단어 모두 매칭됩니다.

# 그러나 문자열 "tomato potato"에 "(pot|tom)ato"를 매칭한 결과를 출력해보면 ['pot', 'tom']가 출력됩니다.

# 그 이유는 파이썬 정규표현식에서 그룹으로 캡쳐한 부분이 있다면 이외의 부분들은 출력하지 않기 때문입니다. 위 패턴에서 ato는 그룹에 속해있지 않기 때문에 findall 함수에서 누락된 것입니다.

# 비캡쳐링 그룹 활용하기
# 이러한 문제를 해결하기 위한 방법 중 하나로 비캡쳐링 그룹이 있습니다.

# 비캡쳐링 그룹은 패턴 문자들을 묶되, 그룹 단위로 매칭되지는 않게끔 해줍니다. 그룹으로 묶은 것들을 최종 결과에서 따로 구분하여 사용하지 않는 경우에 적용합니다.

# 비캡쳐링 그룹을 만드는 방법은 (?:) 입니다.

text = "tomato potato"

p1 = "(tom|pot)ato"    # tomato 또는 potato와 매칭하자
p2 = "(?:tom|pot)ato"  # 올바른 패턴을 작성해보세요.

m1 = re.findall(p1, text)
m2 = re.findall(p2, text)

print("m1 결과 : ", m1)
print("m2 결과 : ", m2)

