package incrementdecrementoperator;

/**
 * 복합 대입 연산자의 계산 과정과 주의점을 확인하는 예제입니다.
 */
public class CompoundAssignmentOperator {

    public static void main(String[] args) {
        int additionValue = 10;
        int subtractionValue = 10;
        int multiplicationValue = 10;
        int divisionValue = 10;
        int remainderValue = 10;

        /*
         * 복합 대입 연산자는 현재 변수의 값으로 계산한 결과를 같은 변수에 다시 저장합니다.
         * 예를 들어 value += 3은 기본적으로 value = value + 3과 같은 뜻입니다.
         */
        additionValue += 3;
        subtractionValue -= 5;
        multiplicationValue *= 10;
        divisionValue /= 3;
        remainderValue %= 3;

        System.out.println("=== 복합 대입 연산 ===");
        System.out.println("10 += 3 -> " + additionValue);         // 13
        System.out.println("10 -= 5 -> " + subtractionValue);      // 5
        System.out.println("10 *= 10 -> " + multiplicationValue);  // 100
        System.out.println("10 /= 3 -> " + divisionValue);         // 3
        System.out.println("10 %= 3 -> " + remainderValue);        // 1

        int expandedExpression = 10;
        int compoundExpression = 10;
        expandedExpression = expandedExpression + 3;
        compoundExpression += 3;

        System.out.println();
        System.out.println("=== 기본 대입식과 비교 ===");
        System.out.println("value = value + 3: " + expandedExpression);
        System.out.println("value += 3: " + compoundExpression);

        /*
         * 복합 대입 연산에는 왼쪽 변수 타입으로의 형변환이 포함됩니다.
         * byteValue = byteValue + 1은 계산 결과가 int라서 그대로는 컴파일되지 않지만,
         * byteValue += 1은 (byte) (byteValue + 1)처럼 동작합니다.
         * 형변환이 자동으로 포함되더라도 표현 범위를 넘으면 값이 순환할 수 있습니다.
         */
        byte byteValue = Byte.MAX_VALUE;
        byteValue += 1;

        System.out.println();
        System.out.println("=== 복합 대입의 형변환 주의점 ===");
        System.out.println("Byte.MAX_VALUE += 1 -> " + byteValue); // -128
    }
}
