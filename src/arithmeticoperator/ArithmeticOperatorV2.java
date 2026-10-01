package arithmeticoperator;

/**
 * 0으로 나눌 때 정수와 실수 연산의 결과가 어떻게 다른지 확인하는 예제입니다.
 */
public class ArithmeticOperatorV2 {

    public static void main(String[] args) {
        int zero = 0;

        /*
         * 정수를 0으로 나누거나 0으로 나머지를 구하면 ArithmeticException이 발생합니다.
         * 프로그램이 중간에 종료되지 않도록 try-catch로 예외를 잡아 메시지를 확인합니다.
         */
        System.out.println("=== 정수와 0의 연산 ===");
        try {
            int integerDivisionResult = 9 / zero;
            System.out.println("9 / 0 = " + integerDivisionResult);
        } catch (ArithmeticException exception) {
            System.out.println("정수 나눗셈 실패: " + exception.getMessage());
        }

        try {
            int integerRemainderResult = 9 % zero;
            System.out.println("9 % 0 = " + integerRemainderResult);
        } catch (ArithmeticException exception) {
            System.out.println("정수 나머지 연산 실패: " + exception.getMessage());
        }

        /*
         * IEEE 754 부동소수점 규칙을 따르는 double 연산은 예외 대신 특별한 값을 만듭니다.
         * 양수를 0.0으로 나누면 Infinity, 0.0을 0.0으로 나누거나
         * 0.0으로 나머지를 구하면 NaN(Not a Number)이 됩니다.
         */
        double positiveInfinity = 9.0 / zero;
        double undefinedDivision = 0.0 / zero;
        double undefinedRemainder = 9.0 % zero;

        System.out.println();
        System.out.println("=== 실수와 0의 연산 ===");
        System.out.println("9.0 / 0 = " + positiveInfinity);
        System.out.println("0.0 / 0 = " + undefinedDivision);
        System.out.println("9.0 % 0 = " + undefinedRemainder);
        System.out.println("첫 번째 결과는 무한대인가? "
                + Double.isInfinite(positiveInfinity));
        System.out.println("두 번째 결과는 NaN인가? "
                + Double.isNaN(undefinedDivision));
    }
}
