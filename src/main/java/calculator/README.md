## 기능 요구사항

사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
X, Y좌표 모두 최대 24까지만 입력할 수 있다.
입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

## TODO

- [x] InputView
  - [x] show:Line // ( , )-( , )에서 Line 생성
- [x] Line
  - [x] draw(StringBuilder)
  - [x] calculateArea:double
- [x] Graph
  - [x] draw(Line):String
- [x] Point(string Ex : // ( , )) x, y값 생성
  - [x] calculateDistance(Point): double 
  - [x] draw(StringBuilder)
- [x] Axis
  - [x] draw(StringBuilder)
- [x] Position(int)
  - [x] calculateDistance(Position)
  - [x] validate(int) throws IllegalArgumentException
- [x] ResultView
  - [x] show(Graph, Line)
  - [x] showError(string)
    