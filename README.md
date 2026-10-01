# 자바 연산자 학습 가이드

이 프로젝트는 자바의 산술, 비교, 논리, 대입, 증감 연산자를 작은 예제로 나누어 학습하기 위한 자료입니다.
각 파일을 실행하기 전에 **출력 결과를 먼저 예상하고**, 실제 결과가 예상과 다르면 피연산자의 타입과 연산 순서를 따라가며 이유를 설명해 보세요.

## 학습 목표

이 프로젝트를 모두 학습하면 다음 내용을 설명할 수 있어야 합니다.

- 다섯 가지 기본 산술 연산자의 결과를 계산할 수 있다.
- 정수 나눗셈과 실수 나눗셈의 차이를 설명할 수 있다.
- 정수와 실수를 0으로 나눌 때 결과가 어떻게 다른지 설명할 수 있다.
- 연산자 우선순위와 괄호가 계산 순서에 미치는 영향을 설명할 수 있다.
- 비교 연산의 결과가 `boolean`이라는 점을 이해하고 범위 검사에 활용할 수 있다.
- `&&`, `||`, `!`의 의미와 진리표를 설명할 수 있다.
- 단락 평가가 불필요하거나 위험한 연산을 건너뛰는 과정을 설명할 수 있다.
- 복합 대입 연산자를 일반 대입식으로 풀어서 설명할 수 있다.
- 전위·후위 증감 연산자가 다른 식 안에서 사용될 때의 차이를 설명할 수 있다.
- 연산 과정에서 발생하는 자동 형변환과 값 손실 가능성을 발견할 수 있다.

## 권장 학습 순서

| 순서 | 예제 | 핵심 주제 |
| --- | --- | --- |
| 1 | `ArithmeticOperatorV1` | 사칙연산, 나머지, 정수 나눗셈, 우선순위 |
| 2 | `ArithmeticOperatorV3` | 피연산자 타입과 나눗셈 결과 |
| 3 | `ArithmeticOperatorV2` | 0으로 나누기, `Infinity`, `NaN` |
| 4 | `ComparisonOperatorV1` | 비교 연산자와 범위 검사 |
| 5 | `LogicalOperatorV1` | AND, OR, 단락 평가 |
| 6 | `LogicalOperatorV2` | NOT과 드모르간 법칙 |
| 7 | `CompoundAssignmentOperator` | 복합 대입과 암시적 형변환 |
| 8 | `IncrementDecrementOperatorV1` | 값을 1씩 증가·감소시키는 방법 |
| 9 | `IncrementDecrementOperatorV2` | 전위·후위 증감 연산의 차이 |

산술 연산의 기본 규칙을 익힌 뒤 비교 연산으로 `boolean` 값을 만들고, 그 값을 논리 연산으로 조합하는 순서입니다. 마지막에는 기존 값을 바꾸는 대입·증감 연산을 학습합니다.

## 예제 실행 방법

### IntelliJ IDEA에서 실행

1. `src` 폴더에서 학습할 Java 파일을 엽니다.
2. `main` 메서드 왼쪽의 실행 아이콘을 누릅니다.
3. 실행 결과를 아래쪽 **Run** 창에서 확인합니다.

패키지 이름은 자바 관례에 맞게 모두 소문자로 작성되어 있습니다. 파일을 옮길 때는 `package` 선언과 폴더 경로가 일치하도록 유지하세요.

### 터미널에서 실행

프로젝트 최상위 폴더에서 다음과 같이 전체 소스를 컴파일할 수 있습니다.

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
```

컴파일 후에는 패키지 이름을 포함한 클래스 이름으로 실행합니다.

```bash
java -cp out arithmeticoperator.ArithmeticOperatorV1
```

다른 예제는 마지막 클래스 이름만 해당 예제에 맞게 바꾸어 실행하세요.

## 1. 기본 산술 연산과 우선순위

학습 파일: [`src/arithmeticoperator/ArithmeticOperatorV1.java`](src/arithmeticoperator/ArithmeticOperatorV1.java)

### 다섯 가지 기본 산술 연산자

| 연산자 | 의미 | `7`과 `2`의 연산 결과 |
| --- | --- | --- |
| `+` | 덧셈 | `9` |
| `-` | 뺄셈 | `5` |
| `*` | 곱셈 | `14` |
| `/` | 나눗셈 | `3` |
| `%` | 나머지 | `1` |

두 피연산자가 모두 정수라면 `/`의 결과도 정수입니다. `7 / 2`의 실제 수학 결과는 `3.5`지만, 자바의 정수 나눗셈은 소수 부분을 버려 `3`을 만듭니다. 이는 반올림이 아닙니다.

`%`는 나눈 뒤 남은 나머지를 구합니다. `number % 2 == 0`은 정수가 짝수인지 확인하는 대표적인 식입니다.

### 연산자 우선순위

곱셈·나눗셈·나머지는 덧셈·뺄셈보다 먼저 계산됩니다.

```java
2 + 3 * 4;   // 2 + 12 = 14
(2 + 3) * 4; // 5 * 4 = 20
```

우선순위를 알고 있더라도 괄호를 사용하면 의도를 더 분명하게 표현할 수 있습니다.

### 직접 해보기

- `firstNumber`를 `8`, `secondNumber`를 `3`으로 바꾸고 다섯 결과를 예상합니다.
- `firstNumber % 2`를 이용해 홀수 여부를 확인하는 식을 작성합니다.
- `10 - 2 * 3`과 `(10 - 2) * 3`의 결과를 비교합니다.

## 2. 피연산자 타입과 나눗셈

학습 파일: [`src/arithmeticoperator/ArithmeticOperatorV3.java`](src/arithmeticoperator/ArithmeticOperatorV3.java)

### 가장 중요한 부분

연산 결과는 결과를 저장할 변수의 타입이 아니라 **연산에 참여하는 피연산자의 타입**에 의해 먼저 결정됩니다.

```java
double result = 9 / 2;
```

오른쪽의 `9 / 2`가 먼저 정수 나눗셈으로 계산되어 `4`가 됩니다. 그다음 `double` 변수에 저장되면서 `4.0`으로 변환됩니다. 왼쪽 변수를 `double`로 선언한 것만으로 이미 끝난 정수 나눗셈을 되돌릴 수는 없습니다.

소수 부분을 보존하려면 계산 전에 적어도 한 피연산자를 실수로 만들어야 합니다.

```java
double first = 9.0 / 2;
double second = 9 / 2.0;
double third = (double) 9 / 2;
```

세 식은 모두 `4.5`를 만듭니다.

### 직접 해보기

- `7 / 2`, `7.0 / 2`, `(double) 7 / 2`의 결과를 비교합니다.
- `(double) (9 / 2)`의 결과를 예상하고 `(double) 9 / 2`와 다른 이유를 설명합니다.
- `float` 리터럴 `9.0f`를 사용했을 때 결과 타입이 무엇인지 확인합니다.

## 3. 0으로 나누기

학습 파일: [`src/arithmeticoperator/ArithmeticOperatorV2.java`](src/arithmeticoperator/ArithmeticOperatorV2.java)

### 정수 연산

정수를 0으로 나누거나 0으로 나머지를 구하면 `ArithmeticException`이 발생합니다. 예제는 `try-catch`를 사용하므로 첫 번째 예외 뒤에도 다음 코드를 계속 관찰할 수 있습니다.

### 실수 연산

`double`과 `float`은 IEEE 754 부동소수점 규칙에 따라 예외 대신 특별한 값을 만들 수 있습니다.

| 연산 | 결과 | 확인 메서드 |
| --- | --- | --- |
| 양수 `/ 0.0` | `Infinity` | `Double.isInfinite(...)` |
| 음수 `/ 0.0` | `-Infinity` | `Double.isInfinite(...)` |
| `0.0 / 0.0` | `NaN` | `Double.isNaN(...)` |
| 실수 `% 0.0` | `NaN` | `Double.isNaN(...)` |

`NaN`은 어떤 값과도 같지 않으며 자기 자신과 `==`로 비교해도 `false`입니다. `NaN` 여부는 `Double.isNaN`으로 확인하세요.

### 직접 해보기

- `-9.0 / zero`의 결과가 음의 무한대인지 확인합니다.
- `undefinedDivision == Double.NaN`의 결과를 예상하고 `Double.isNaN`과 비교합니다.
- `try-catch`를 잠시 제거했을 때 정수 연산 뒤의 코드가 실행되는지 확인한 후 원상 복구합니다.

## 4. 비교 연산자

학습 파일: [`src/comparisonoperator/ComparisonOperatorV1.java`](src/comparisonoperator/ComparisonOperatorV1.java)

### 비교 연산의 결과

| 연산자 | 확인하는 내용 |
| --- | --- |
| `>` | 왼쪽이 오른쪽보다 큰가? |
| `>=` | 왼쪽이 오른쪽보다 크거나 같은가? |
| `<` | 왼쪽이 오른쪽보다 작은가? |
| `<=` | 왼쪽이 오른쪽보다 작거나 같은가? |
| `==` | 두 값이 같은가? |
| `!=` | 두 값이 다른가? |

모든 비교 연산의 결과 타입은 `boolean`입니다. `=`는 오른쪽 값을 왼쪽 변수에 저장하는 대입 연산자이고, `==`는 두 값이 같은지 확인하는 비교 연산자입니다.

### 범위 검사

수학에서는 `1 < value < 5`처럼 쓸 수 있지만 자바에서는 사용할 수 없습니다. 첫 번째 비교 결과가 숫자가 아닌 `boolean`이기 때문입니다.

```java
boolean isInRange = 1 < value && value < 5;
```

경계값을 포함하려면 `<=`를 사용합니다. 예를 들어 `1 <= value && value <= 5`는 1과 5도 범위에 포함합니다.

### 직접 해보기

- 두 숫자를 같게 바꾸고 여섯 비교 결과를 예상합니다.
- `value`를 `1`, `3`, `5`로 바꾸어 범위 검사 결과를 비교합니다.
- 1 이상 5 이하를 검사하도록 식을 변경합니다.

## 5. AND, OR와 단락 평가

학습 파일: [`src/logicaloperator/LogicalOperatorV1.java`](src/logicaloperator/LogicalOperatorV1.java)

### AND와 OR

- `조건A && 조건B`: 두 조건이 모두 `true`일 때만 `true`
- `조건A || 조건B`: 하나 이상의 조건이 `true`이면 `true`

예제의 진리표를 가리지 않고 각 출력을 먼저 예상해 보세요.

### 단락 평가

`&&`와 `||`는 왼쪽부터 평가하며, 전체 결과가 이미 결정되면 오른쪽 식을 실행하지 않습니다.

- `false && 오른쪽`: AND 결과는 이미 `false`이므로 오른쪽을 건너뜁니다.
- `true || 오른쪽`: OR 결과는 이미 `true`이므로 오른쪽을 건너뜁니다.

이 동작 덕분에 다음과 같이 `null`을 안전하게 검사할 수 있습니다.

```java
text != null && text.length() > 3
```

순서를 바꿔 `text.length() > 3 && text != null`로 작성하면 `null`인 객체에서 메서드를 먼저 호출하므로 `NullPointerException`이 발생합니다. 단락 평가를 예외를 숨기는 용도로 남용하기보다, 값이 안전한지 먼저 검사하는 논리적 순서를 표현하는 데 사용하세요.

### 직접 해보기

- 네 개의 AND 결과와 네 개의 OR 결과를 코드 실행 전에 적어 봅니다.
- `number < 5`를 `number > 5`로 바꾸고 어떤 예외가 발생하는지 확인한 뒤 되돌립니다.
- `text`에 `"Java"`를 저장하고 `safeAndResult`가 어떻게 바뀌는지 확인합니다.

## 6. NOT과 드모르간 법칙

학습 파일: [`src/logicaloperator/LogicalOperatorV2.java`](src/logicaloperator/LogicalOperatorV2.java)

`!`는 `boolean` 값을 반대로 바꾸는 NOT 연산자입니다.

```java
!true   // false
!false  // true
```

비교식 전체를 부정할 때는 괄호로 범위를 분명히 나타냅니다. `!(age >= 19)`는 `age < 19`와 같은 의미입니다.

드모르간 법칙을 사용하면 복합 조건의 부정을 풀어 쓸 수 있습니다.

```java
!(A && B) == (!A || !B)
!(A || B) == (!A && !B)
```

여기서 `==`는 두 식의 논리 결과가 같다는 의미로 사용했습니다. 실제 조건을 변환할 때는 `&&`와 `||`가 서로 바뀐다는 점을 놓치지 마세요.

### 직접 해보기

- `age`를 `19`로 바꾸고 `isMinor`의 결과를 예상합니다.
- `hasIdCard`와 `hasTicket`의 네 가지 조합에서 두 드모르간 식이 항상 같은지 확인합니다.
- `!(age == 18)`을 `!=`를 사용한 식으로 바꾸어 봅니다.

## 7. 복합 대입 연산자

학습 파일: [`src/incrementdecrementoperator/CompoundAssignmentOperator.java`](src/incrementdecrementoperator/CompoundAssignmentOperator.java)

복합 대입 연산자는 계산과 대입을 하나로 표현합니다.

| 복합 대입 | 기본 형태 |
| --- | --- |
| `value += number` | `value = value + number` |
| `value -= number` | `value = value - number` |
| `value *= number` | `value = value * number` |
| `value /= number` | `value = value / number` |
| `value %= number` | `value = value % number` |

### 형변환 주의점

두 표현이 언제나 컴파일 관점에서도 완전히 같은 것은 아닙니다. 복합 대입에는 왼쪽 변수 타입으로의 형변환이 포함됩니다.

```java
byte value = 10;
// value = value + 1; // value + 1은 int이므로 컴파일 오류
value += 1;           // (byte) (value + 1)과 같은 효과
```

자동으로 포함된 형변환은 값이 안전하다는 뜻이 아닙니다. `Byte.MAX_VALUE`인 `127`에 `+= 1`을 적용하면 범위를 넘어 `-128`이 됩니다.

### 직접 해보기

- 각 복합 대입의 오른쪽 값을 바꾸고 결과를 예상합니다.
- `divisionValue`의 초기값을 `11`로 바꾸어 정수 나눗셈 결과를 확인합니다.
- `byteValue`의 초기값을 `126`으로 바꾸고 두 번 `+= 1`을 실행합니다.

## 8. 증감 연산자 기초

학습 파일: [`src/incrementdecrementoperator/IncrementDecrementOperatorV1.java`](src/incrementdecrementoperator/IncrementDecrementOperatorV1.java)

`++`는 값을 1 증가시키고 `--`는 값을 1 감소시킵니다.

```java
value = value + 1;
value += 1;
value++;
```

세 문장은 `int` 변수의 값을 1 증가시킨다는 점에서 같은 최종 결과를 만듭니다. 증감 연산자를 독립된 문장으로 사용하면 `++value`와 `value++`의 최종 결과도 같습니다.

### 직접 해보기

- 세 증가 변수의 초기값을 모두 `10`으로 바꾸고 결과를 확인합니다.
- 감소 연산을 `value = value - 1`, `value -= 1`, `value--`로 각각 작성합니다.
- `Integer.MAX_VALUE`에 `++`를 적용했을 때 결과를 예상합니다.

## 9. 전위·후위 증감 연산자

학습 파일: [`src/incrementdecrementoperator/IncrementDecrementOperatorV2.java`](src/incrementdecrementoperator/IncrementDecrementOperatorV2.java)

증감 연산자가 다른 식의 일부로 사용되면 위치에 따라 식에 제공하는 값이 달라집니다.

| 형태 | 실행 순서 | 원본 값이 1일 때 식의 결과 | 연산 후 원본 |
| --- | --- | --- | --- |
| `++value` | 먼저 증가, 그다음 사용 | `2` | `2` |
| `value++` | 먼저 사용, 그다음 증가 | `1` | `2` |
| `--value` | 먼저 감소, 그다음 사용 | `0` | `0` |
| `value--` | 먼저 사용, 그다음 감소 | `1` | `0` |

`int result = value++ + ++value;`처럼 한 문장에 여러 증감 연산을 섞으면 계산은 가능하지만 읽고 수정하기 어렵습니다. 값을 변경하는 문장과 사용하는 문장을 분리하면 의도가 분명해집니다.

### 직접 해보기

- 전위·후위 증가 예제를 감소 연산자로 바꾸고 결과를 예상합니다.
- 각 원본 값을 `5`로 바꾸고 식의 결과와 최종 원본 값을 적어 봅니다.
- `value++`를 독립된 문장으로 옮겼을 때 코드가 더 읽기 쉬운지 비교합니다.

## 자주 혼동하는 부분

| 혼동하기 쉬운 코드 | 실제 의미 |
| --- | --- |
| `double result = 9 / 2` | 정수 나눗셈 후 `4.0` 저장 |
| `double result = 9.0 / 2` | 실수 나눗셈으로 `4.5` 저장 |
| `value = 3` | `3`을 변수에 대입 |
| `value == 3` | 값이 `3`인지 비교 |
| `conditionA && conditionB` | 두 조건이 모두 참인지 확인 |
| `conditionA || conditionB` | 하나 이상의 조건이 참인지 확인 |
| `++value` | 증가한 값을 식에 사용 |
| `value++` | 현재 값을 식에 사용한 뒤 증가 |

## 권장 학습 방법

각 예제에서 다음 과정을 반복하면 코드를 단순히 따라 입력하는 것보다 개념을 오래 기억할 수 있습니다.

1. 주석과 실행 결과를 가리고 각 변수의 값을 손으로 계산합니다.
2. 코드를 실행하고 예상한 값과 실제 출력을 비교합니다.
3. 예상과 다른 줄은 피연산자의 타입과 평가 순서를 적어 봅니다.
4. `직접 해보기`의 값을 하나씩 변경하여 다시 실행합니다.
5. 마지막에는 코드를 보지 않고 결과가 나온 이유를 설명합니다.

## 최종 점검 질문

1. 두 정수를 `/`로 나누면 소수 부분은 어떻게 되나요?
2. `%` 연산자는 어떤 값을 반환하며 어디에 활용할 수 있나요?
3. `2 + 3 * 4`와 `(2 + 3) * 4`의 결과가 다른 이유는 무엇인가요?
4. `double result = 9 / 2`가 `4.5`가 아닌 이유는 무엇인가요?
5. 정수 나눗셈에서 소수 부분을 보존하려면 어떻게 해야 하나요?
6. 정수를 0으로 나눌 때 발생하는 예외는 무엇인가요?
7. 실수의 `Infinity`와 `NaN`은 각각 어떤 연산에서 만들어질 수 있나요?
8. 대입 연산자 `=`와 비교 연산자 `==`는 어떻게 다른가요?
9. 자바에서 `1 < value < 5`를 그대로 쓸 수 없는 이유는 무엇인가요?
10. `&&`와 `||`는 각각 어떤 조건에서 `true`가 되나요?
11. 단락 평가는 오른쪽 식을 언제 실행하지 않나요?
12. `text != null && text.length() > 3`에서 `null` 확인을 먼저 해야 하는 이유는 무엇인가요?
13. `!(A && B)`를 드모르간 법칙으로 바꾸면 어떤 식이 되나요?
14. `value += 3`은 기본적으로 어떤 대입식과 같은 뜻인가요?
15. `byte`의 복합 대입 연산에서 값이 순환할 수 있는 이유는 무엇인가요?
16. 증감 연산자를 독립된 문장으로 사용할 때 전위형과 후위형의 최종 결과는 어떻게 되나요?
17. `int result = ++value`와 `int result = value++`의 차이는 무엇인가요?
18. 한 문장에 여러 증감 연산자를 섞지 않는 편이 좋은 이유는 무엇인가요?

질문에 답하기 어렵다면 해당 예제로 돌아가 값을 바꾸고 실행 과정부터 다시 추적해 보세요.
