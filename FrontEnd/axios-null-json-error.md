# [HTTP 요청 사연] Axios에서 `null`을 보냈더니 생긴 일

오늘은 아주 사소하지만 중요한, 그리고 누구나 한 번쯤은 겪을 수 있는 HTTP 요청 실수에 대해 이야기해보려고 한다.

## 사건의 발단

서버에 POST 요청을 보내야 했다. 그런데 특별히 보낼 데이터는 없어서, 다음과 같이 `null`을 body에 실어서 보냈다.

```ts
axios.post("/api/something", null, {
  headers: {
    "Content-Type": "application/json",
  },
});
```

이때까지만 해도 아무 문제가 없을 줄 알았다. 하지만 요청을 보내자마자 클라이언트에서 예외가 발생했다. 대략 이런 에러였다:

```
SyntaxError: Unexpected token 'n', "null" is not valid JSON
```

## 뭐가 문제였을까?

처음엔 axios 버그인가 싶어서 공식문서를 다시 뒤져봤다. 하지만 문제는 내 코드에 있었다.

원인은 바로 **`Content-Type: application/json`** 헤더였다.

이 헤더는 "이 요청의 body는 JSON 형식입니다"라고 명시하는 것인데, 나는 아무 생각 없이 이걸 붙여놓고 `null`을 보냈다. 그런데 `null`은 JSON에서 유효한 값이긴 하지만, 전체적인 구조 없이 단독으로 들어가면 axios 내부에서 파싱할 때 문제가 생긴다. 특히, 일부 서버나 클라이언트는 `null`을 JSON 객체로 처리하지 않고 단일 값으로 해석해 에러를 낼 수 있다.

즉, `application/json`을 선언했으면 적어도 다음과 같이 **빈 JSON 객체**를 보내야 했던 것이다.

```ts
axios.post(
  "/api/something",
  {},
  {
    headers: {
      "Content-Type": "application/json",
    },
  }
);
```

## 교훈

- `Content-Type: application/json`은 반드시 body를 **JSON 형식**으로 보내겠다는 약속이다.
- body가 없다고 해서 `null`을 보내면 의도치 않은 파싱 오류가 날 수 있다.
- 보낼 게 없다면 `{}`처럼 명시적인 빈 객체를 보내자.
- 또는, 정말 아무것도 안 보낼 거라면 `Content-Type`을 빼거나 `application/x-www-form-urlencoded`, `text/plain` 같은 다른 타입을 고려하자.

## 마무리

사소한 실수였지만, 덕분에 HTTP 요청 헤더와 body의 관계를 다시 한 번 돌아보는 계기가 되었다. axios를 쓴다면 이런 부분에 특히 더 주의하자. 바쁜 와중에 예상 못 한 에러 한 방이면 디버깅 시간만 날아간다. 🙃

~~나도 알고싶지 않았다...~~
