package incrementdecrementoperator;

/**
 * 증감 연산자로 변수의 값을 1씩 변경하는 방법을 확인하는 예제입니다.
 */
public class IncrementDecrementOperatorV1 {

    public static void main(String[] args) {
        int incrementValue = 1;
        int decrementValue = 1;

        /*
         * ++는 변수의 값을 1 증가시키고 --는 1 감소시킵니다.
         * 아래처럼 증감 연산자를 한 문장에 단독으로 사용하면
         * 전위형(++value)과 후위형(value++)의 최종 결과는 같습니다.
         */
        ++incrementValue;
        --decrementValue;

        System.out.println("=== 증감 연산 ===");
        System.out.println("1에서 1 증가: " + incrementValue); // 2
        System.out.println("1에서 1 감소: " + decrementValue); // 0

        /* 같은 동작은 일반 대입식 또는 복합 대입식으로도 표현할 수 있습니다. */
        int expandedIncrement = 1;
        int compoundIncrement = 1;
        int postfixIncrement = 1;

        expandedIncrement = expandedIncrement + 1;
        compoundIncrement += 1;
        postfixIncrement++;

        System.out.println();
        System.out.println("=== 1 증가 표현 비교 ===");
        System.out.println("value = value + 1: " + expandedIncrement);
        System.out.println("value += 1: " + compoundIncrement);
        System.out.println("value++: " + postfixIncrement);
    }
}
