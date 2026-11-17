# e03. 조건문 (if / switch)

## 1. if / else if / else

```java
if (조건1) {
    // 조건1이 true일 때
} else if (조건2) {
    // 조건1이 false이고 조건2가 true일 때
} else {
    // 위 조건이 모두 false일 때
}
```

위에서부터 순서대로 검사하고, **처음으로 `true`가 되는 블록 하나만** 실행한 뒤 빠져나온다.

### 실습: 점수에 따른 학점 출력

```java
int score = 0;
String str = null;

if (score >= 0 && score <= 100) {
    if (score == 100) {
        str = "A+";
    } else if (score >= 90) {
        str = "A";
    } else if (score >= 80) {
        str = "B";
    } else if (score >= 70) {
        str = "C";
    } else if (score >= 60) {
        str = "D";
    } else {
        str = "F";
    }
    System.out.println("당신의 점수는 " + str + "입니다");
} else {
    System.out.println("유효한 점수가 아닙니다");
}
```

- 바깥 `if`에서 0~100 범위를 먼저 검사해 잘못된 입력을 걸러낸다.
- 정상적인 경우를 먼저 작성하고 예외를 `else`로 처리하면 코드를 읽기 쉽다.

유효하지 않은 값을 먼저 걸러내는 방식으로도 작성할 수 있다. 이때는 조건을 `||`로 연결한다.

```java
if (score < 0 || score > 100) {
    System.out.println("유효한 점수가 아닙니다");
} else {
    // 정상 처리
}
```

---

## 2. switch

값이 **정확히 일치**하는지 비교해서 분기한다.

```java
int num = 1;

switch (num) {
    case 1:
        System.out.println("1등");
        break;
    case 2:
        System.out.println("2등");
        break;
    case 3:
        System.out.println("3등");
        break;
    default:
        System.out.println("등수 외");
        break;
}
```

- 일치하는 `case`가 없으면 `default`가 실행된다. (`if`의 `else`와 같은 역할)
- `break`를 만나면 `switch`를 빠져나간다.

---

## 3. 테스트 케이스와 경계값

작성한 코드가 의도대로 동작하는지 값을 넣어 확인하는 것이 테스트다. 모든 값을 테스트할 수 없으므로 보통 **경계값**을 중심으로 테스트한다.

경계값 테스트는 기준이 되는 값과 그 바로 앞뒤 값을 검사하는 방법이다.

| 기준 | 테스트할 값 |
| --- | --- |
| 100 | 99, 100 (101은 범위 밖 테스트) |
| 90 | 89, 90, 91 |
| 80 | 79, 80, 81 |
| 70 | 69, 70, 71 |
| 60 | 59, 60, 61 |
| 0 | -1, 0 |

---

## 헷갈리기 쉬운 포인트

### `switch`에서 `break`를 빼먹으면?

```java
switch (num) {
    case 3:
        System.out.println("3등");   // break 없음
    default:
        System.out.println("등수 외");
        break;
}
```

`num`이 3이면 `"3등"`과 `"등수 외"`가 **둘 다** 출력된다. `break`가 없으면 일치한 `case`부터 아래 `case`들을 차례로 계속 실행하기 때문이다. 이를 **fall-through**라고 한다.

단, `switch`의 끝에 도달하면 종료되므로 무한 루프가 되지는 않는다.

### `else if`의 순서

```java
// 잘못된 순서
if (score >= 80) {
    str = "B";
} else if (score >= 90) {   // 95점도 위에서 먼저 걸려서 여기까지 오지 않음
    str = "A";
}
```

`if`는 처음으로 `true`가 되는 블록만 실행한다. 범위 조건은 **더 좁은 조건(큰 값)부터** 작성해야 한다.

### `&&`와 `||` 선택
- 정상 범위를 검사할 때: `score >= 0 && score <= 100` (두 조건을 모두 만족)
- 비정상 범위를 검사할 때: `score < 0 || score > 100` (둘 중 하나라도 만족)

같은 내용이라도 무엇을 기준으로 검사하느냐에 따라 연결하는 연산자가 달라진다.

---

## if vs switch

| | if | switch |
| --- | --- | --- |
| 비교 방식 | 범위 비교 가능 (`score >= 90`) | 값 일치 비교만 가능 (`case 1:`) |
| 나머지 처리 | `else` | `default` |
| `break` | 사용하지 않음 | 다음 `case`로 넘어가지 않도록 사용 |
| 실행되는 블록 | 처음 일치하는 블록 하나 | 일치하는 `case`부터 `break`까지 |

## 언제 무엇을 사용하나

| 상황 | 사용 |
| --- | --- |
| 범위로 나눌 때 (점수, 나이 등) | `if` |
| 정해진 값으로 나눌 때 (등수, 메뉴 번호 등) | `switch` |
| 결과가 두 가지뿐인 짧은 분기 | 삼항 연산자 |
