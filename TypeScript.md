## TypeScript란?

> 타입스크립트는 자바스크립트에 타입이 추가된 언어입니다.

- TypeScript는 JavaScript의 Superset이므로 기존의 자바스크립트(ES5)문법을 그대로 사용할 수 있습니다.
- 정적 타입을 지원하므로 코드의 가독성을 높이고 디버깅을 쉽게 할 수 있게 하여 협업에 용이합니다.

### Non-exception Failures

이러한 코드가 있다고 해봅시다.

```typescript
const user = {
  name: "daniel",
  age: 26,
};

user.location;
```

이 코드를 js에서 실행하면 undefined를 반환하고 ts에서는 에러를 발생시킵니다.
다시말해, js에서는 존재하지 않은 객체에 접근해도 valid 하지만 ts에서는 즉시 error를 발생시킵니다.

이처럼 ts에서는 컴파일 단계에서 오류를 포착할 수 있는 장점이 있어 개발 시간을 단축시킬 수 있습니다.

이 외에도 타입스크립트에서는 여러 문법적 버그들을 찾아줍니다.

1. 타이핑 에러

```typescript
const announcement = "Hello World!";
// How quickly can you spot the typos?
announcement.toLocaleLowercase();
announcement.toLocalLowerCase();
// We probably meant to write this...
announcement.toLocaleLowerCase();
```

2. uncalled function

```typescript
function flipCoin() {
  // Meant to be Math.random()
  return Math.random < 0.5;
  // Operator '<' cannot be applied to types '() => number' and 'number'.
}
```

3. 기본적인 문법 에러

```typescript
const value = Math.random() < 0.5 ? "a" : "b";
if (value !== "a") {
 // ...
} else if (value === "b") {
This condition will always return 'false' since the types '"a"' and
'"b"' have no overlap.
 // Oops, unreachable
}

```

### 타입스크립트 컴파일러 "tsc"

> 설치 방법
> **npm install -g typescript**

#### typeScript파일 터미널로 실행하기

vscode에 hello.ts파일을 생성한다.

terminal에 tsc typescript파일이름 을 작성하고 실행하면 js 파일이 생성된다.

> **_tsc hello.ts _**
> -> hello.js 파일 생성/업데이트

> **_ node hello.js_**
> -> hello.js 파일 실행

> **_ tsc --noEmitOnError hello.ts _**
> -> 에러가 없었을 때만 hello.js 파일 생성/업데이트

**알아야 할 것!**
java는 컴파일 에러시 class 파일 생성이 되지 않지만 ts는 오류가 나도 js파일이 생성 또는 업데이트된다. 이는 오류가 나는 파일로 업데이트가 될 수 있다는 뜻이고 큰 장애를 낳을 수 있는 문제이다. 이를 방지하려면 tsc --noEmitOnError ts파일이름 을 사용하면 된다.

### 타입 추가 해보기

이 코드를 TS로 실행시키면 결과가 어떻게 될까?

```typescript
function greet(person: string, date: Date) {
  console.log(`Hello ${person}, today is ${date.toDateString()}!`);
}
greet("soni", Date());
```

> **결과**
> Argument of type 'string' is not assignable to parameter of type 'Date'.

그 이유는 javascript에서 new 없이 Date()를 호출하면 반환 타입이 string인데 함수에서 파라미터의 타입을 Date타입으로 지정했기 때문에 에러가 나는 것이다.

이를 에러가 나지 않도록 수정하면 하단의 코드이다.

```typescript
function greet(person: string, date: Date) {
  console.log(`Hello ${person}, today is ${date.toDateString()}!`);
}
greet("soni", new Date());
```

참고사항

- 변수의 타입을 명시할 때에는 "변수명 : 타입"의 형태를 따른다.
- ts는 모든 변수에 전부 type annotation을 붙이지 않는다. 많은 경우 ts는 타입 추론이 가능하다.
- 상단 코드에서 ` today is ${date}`도 버그를 발생시키지 않는다.
  다만 실행결과가* today is Mon Oct 17 2022 16:52:13 GMT +0900 (대한민국 표준시)*로 나온다.

ts에서 js로 바뀌면 일어나는 일

1. 모든 type annotations가 사라진다.
2. template string이 plain string with concatenations로 변환된다.

> point : type annotations는 절대 프로그램의 runtime behavior를 바꾸지 않습니다.

## Downleveling

### Template strings가 plain string으로 바뀌는 이유가 뭘까?

Template strings는 *ECMAScript*의 특정 버전 (ES6 등)의 특징이다.
TypeScript는 ECMAScript의 높은 버전 코드를 낮은 버전으로 변환하는 능력이 있다. 이를 **_downleveling_** 이라고 한다.

#### 참고자료

> https://velog.io/@taeg92/TypeScript-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0
> https://www.typescriptlang.org/assets/typescript-handbook.pdf
