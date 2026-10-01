package incrementdecrementoperator;

/**
 * 전위·후위 증감 연산자가 다른 식 안에서 사용될 때의 차이를 확인하는 예제입니다.
 */
public class IncrementDecrementOperatorV2 {

    public static void main(String[] args) {
        /*
         * 전위 증가(++value)는 값을 먼저 증가시킨 다음 증가한 값을 식에 사용합니다.
         * prefixSource는 2가 되고, 그 값 2가 prefixResult에 저장됩니다.
         */
        int prefixSource = 1;
        int prefixResult = ++prefixSource;

        System.out.println("=== 전위 증가 ===");
        System.out.println("식의 결과: " + prefixResult);       // 2
        System.out.println("연산 후 원본 값: " + prefixSource); // 2

        /*
         * 후위 증가(value++)는 현재 값을 식에 먼저 사용한 다음 원본 값을 증가시킵니다.
         * postfixResult에는 기존 값 1이 저장되고, postfixSource는 2가 됩니다.
         */
        int postfixSource = 1;
        int postfixResult = postfixSource++;

        System.out.println();
        System.out.println("=== 후위 증가 ===");
        System.out.println("식의 결과: " + postfixResult);        // 1
        System.out.println("연산 후 원본 값: " + postfixSource);  // 2

        /*
         * 한 문장에 증감 연산자를 여러 번 섞으면 실행 순서를 파악하기 어렵습니다.
         * 실제 코드에서는 값을 변경하는 문장과 사용하는 문장을 나누는 편이 읽기 쉽습니다.
         */
        int readableValue = 1;
        readableValue++;
        int copiedValue = readableValue;

        System.out.println();
        System.out.println("=== 읽기 쉬운 표현 ===");
        System.out.println("증가 후 복사한 값: " + copiedValue); // 2
    }
}
