# white-space

> white-space는 스페이스와 탭, 줄바꿈, 자동 줄바꿈을 어떻게 처리할지 정하는 속성이다.
>
> white-space: normal | nowrap | pre | pre-wrap | pre-line | initial | inherit


<table>
    <tr>
        <td></td>
        <td>스페이스와 탭</td>
        <td>줄바꿈</td>
        <td>자동 줄바꿈</td>
    </tr>
    <tr>
        <td>nomal</td>
        <td>1개의 공백으로 변환</td>
        <td>1개의 공백으로 변환</td>
        <td>O</td>
    </tr>
    <tr>
        <td>nowrap</td>
        <td>1개의 공백으로 변환</td>
        <td>1개의 공백으로 변환</td>
        <td>X</td>
    </tr>
    <tr>
        <td>pre</td>
        <td>입력된 그대로 출력</td>
        <td>입력된 그대로 출력</td>
        <td>X</td>
    </tr>
    <tr>
        <td>nomal</td>
        <td>입력된 그대로 출력</td>
        <td>입력된 그대로 출력</td>
        <td>O</td>
    </tr>
    <tr>
        <td>nomal</td>
        <td>1개의 공백으로 변환</td>
        <td>입력된 그대로 출력</td>
        <td>O</td>
    </tr>
</table>

- nowrap의 경우 공백을 많이 넣고 엔터를 넣어도 공백으로 변환되며 영역을 벗어나도 줄바꿈이 되지 않는다. 줄바꿈이 되지 않아 다른 영역을 침범하여 UI가 깨질 수 있으니 유의해야한다.

