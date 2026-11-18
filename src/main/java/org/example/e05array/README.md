# e05. 배열

## 1. 배열 기본

배열은 **같은 타입**의 값 여러 개를 하나의 변수로 다루는 참조형 데이터 타입이다.

| | JavaScript 배열 | Java 배열 |
| --- | --- | --- |
| 길이 | 자유롭게 늘이고 줄일 수 있음 | 생성할 때 정한 길이로 고정 |
| 요소 타입 | 섞어서 저장 가능 | 선언한 타입만 저장 가능 |
| 선언 | `[1, 2, 3]` | `int[] arr = {1, 2, 3};` |

```java
int[] arrI = new int[3];  // 길이 3의 int 배열 생성 (기본값 0으로 채워짐)
arrI[0] = 1;
arrI[1] = 2;
arrI[2] = 3;

int[] arr2 = {1, 2, 3};   // 생성과 동시에 값 지정
```

- 길이를 벗어난 인덱스에 접근하면 `ArrayIndexOutOfBoundsException`이 발생한다.
- 요소에 값을 넣지 않아도 배열 객체가 생성되고 그 주소가 변수에 저장되므로, 변수는 초기화된 상태다.

### 인덱스와 length

| 표기 | 의미 | `{10, 20, 30, 40}`일 때 |
| --- | --- | --- |
| `arr[1]` | 1번 인덱스의 값 (0부터 시작) | `20` |
| `arr.length` | 요소의 개수 | `4` |

마지막 요소의 인덱스는 항상 `length - 1`이다.

### 배열 출력

```java
System.out.println(arrI);                   // [I@1b6d3586 (객체 식별값)
System.out.println(Arrays.toString(arrI));  // [1, 2, 3]
```

`println()`은 객체의 `toString()`을 호출하는데, 배열의 `toString()`은 내용이 아니라 객체 식별값을 반환한다. 내용을 확인하려면 `Arrays.toString()`을 사용하거나 디버깅 모드에서 변수 값을 확인한다.

---

## 2. 값 복사와 주소 복사

`=`는 변수에 저장된 값을 그대로 복사한다. 기본형은 값 자체가, 참조형은 주소가 저장되어 있으므로 결과가 다르다.

```java
// 기본형: 값이 복사된다
int a = 5;
int b = a;
b = 10;        // a는 5 그대로

// 참조형: 주소가 복사된다 (얕은 복사)
int[] arrA = {5};
int[] arrB = arrA;
arrB[0] = 10;  // arrA[0]도 10
```

```
arrA → 0x01 ─┐
arrB → 0x01 ─┴→ [10]
```

| 타입 | `b = a` 결과 | `b`의 내용을 수정하면 `a`는 |
| --- | --- | --- |
| 기본형 (`int`, `double`, `boolean` 등) | 값 복사 | 변하지 않음 |
| 참조형 (배열, 객체) | 주소 복사 | 함께 변함 |

함께 변하는 것은 **주소를 따라가 내용을 수정할 때**뿐이다. 변수에 새 배열을 대입하면 다른 주소를 가리키게 되므로 원래 변수에는 영향이 없다.

```java
arrB[0] = 10;          // 내용 수정 → arrA도 변함
arrB = new int[]{99};  // 새 주소 대입 → arrA는 그대로
```

---

## 3. 깊은 복사

새 배열을 만들고 값을 하나씩 옮겨 담아 원본과 다른 주소를 갖게 하는 복사다. 복사본을 수정해도 원본은 변하지 않는다.

| 방법 | 동작 | 사용 상황 |
| --- | --- | --- |
| 반복문 직접 구현 | 요소를 하나씩 대입 | 원리 이해 |
| `System.arraycopy()` | 미리 만든 배열에 지정한 범위를 복사 | 길이를 늘려서 복사할 때 |
| `Arrays.copyOf()` | 새 배열을 생성해 반환 | 원본과 같은 배열을 복사할 때 |

### System.arraycopy()

```java
int[] originArrSystem = {1, 2, 3};
int[] copyArrSystem = new int[originArrSystem.length * 2];

System.arraycopy(
        originArrSystem,         // 원본 배열
        0,                       // 원본 시작 인덱스
        copyArrSystem,           // 복사받을 배열
        0,                       // 복사받을 배열의 시작 인덱스
        originArrSystem.length   // 복사할 길이
);
// copyArrSystem → [1, 2, 3, 0, 0, 0]
```

### Arrays.copyOf()

```java
int[] originArrArrays = {1, 2, 3};
int[] copyArrArrays = Arrays.copyOf(originArrArrays, originArrArrays.length);
```

`copyOf()`는 내부에서 새 배열을 생성해 반환한다. 따라서 미리 `new`로 만들어 둔 배열에 대입하면 그 배열은 반환된 배열로 대체되어 사용되지 않는다.

```java
int[] copyArrArrays = new int[len * 2];      // 길이 6 배열 생성
copyArrArrays = Arrays.copyOf(origin, len);   // 길이 3 배열로 대체됨
```

`copyOf()`는 내부적으로 `System.arraycopy()`를 사용한다. 기존 메소드를 감싸 새 메소드를 만드는 방식을 래핑(wrapping)이라고 한다.

### 반복문으로 구현

```java
int[] originFor = {1, 2, 3};
int[] copyFor = new int[originFor.length * 2];

// 일반 for
for (int i = 0; i < originFor.length; i++) {
    copyFor[i] = originFor[i];
}

// 향상된 for: 값만 꺼내므로 인덱스를 별도로 관리한다
int idx = 0;
for (int val : originFor) {
    copyFor[idx] = val;
    idx++;
}
```

---

## 4. 다차원 배열

배열 안에 배열이 들어 있는 구조다. 대괄호를 차원 수만큼 이어서 접근한다.

```java
int[][] multiArr = {
        {1, 2, 3},
        {1, 2, 3},
        {1, 2, 3}
};
System.out.println(multiArr[1][1]); // 2
```

---

## 5. 배열 API

| 메소드 | 설명 |
| --- | --- |
| `arr.length` | 배열 길이 (메소드가 아닌 속성) |
| `Arrays.toString(arr)` | 배열 내용을 문자열로 반환 |
| `Arrays.equals(a, b)` | 1차원 배열의 요소 값 비교 |
| `Arrays.deepEquals(a, b)` | 다차원 배열의 요소 값 비교 |
| `Arrays.sort(arr)` | 오름차순 정렬 (원본 배열을 변경) |

```java
int[][] deepArr1 = {{1, 2, 3}, {4, 5, 6}};
int[][] deepArr2 = {{1, 2, 3}, {4, 5, 7}};
System.out.println(Arrays.deepEquals(deepArr1, deepArr2)); // false

int[] sortArr = {43, 6, 7, 8, 4, 34, 2};
Arrays.sort(sortArr);
System.out.println(Arrays.toString(sortArr)); // [2, 4, 6, 7, 8, 34, 43]
```

- 다차원 배열에 `equals()`를 사용하면 안쪽 배열을 주소로 비교하므로 `deepEquals()`를 사용해야 한다.
- `sort()`는 원본 배열을 변경한다. 원본을 유지해야 하면 복사본을 만들어 정렬한다.
