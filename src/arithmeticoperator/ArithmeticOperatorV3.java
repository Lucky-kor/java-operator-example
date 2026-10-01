package arithmeticoperator;

/**
 * 나눗셈에서 피연산자의 타입이 결과에 미치는 영향을 확인하는 예제입니다.
 */
public class ArithmeticOperatorV3 {

    public static void main(String[] args) {
        /*
         * 9와 2가 모두 int이므로 9 / 2는 정수 나눗셈입니다.
         * 계산 결과의 소수 부분을 버린 4가 만들어집니다.
         */
        int integerResult = 9 / 2;

        /*
         * 오른쪽 식의 계산이 끝난 뒤 결과가 왼쪽 변수에 저장됩니다.
         * 따라서 double 변수에 저장하더라도 9 / 2는 먼저 정수 4가 되고,
         * 그 후 double로 자동 형변환되어 4.0이 됩니다.
         */
        double tooLateResult = 9 / 2;

        /*
         * 피연산자 중 하나가 double이면 다른 피연산자도 double로 변환된 뒤 계산됩니다.
         * 그러므로 9.0 / 2와 9 / 2.0은 모두 4.5입니다.
         */
        double firstDoubleOperandResult = 9.0 / 2;
        double secondDoubleOperandResult = 9 / 2.0;

        /* 정수 변수끼리 나눌 때는 계산 전에 한 값을 명시적으로 형변환할 수 있습니다. */
        int dividend = 9;
        int divisor = 2;
        double castingResult = (double) dividend / divisor;

        System.out.println("=== 피연산자 타입에 따른 나눗셈 ===");
        System.out.println("int 9 / int 2 -> int: " + integerResult);
        System.out.println("int 9 / int 2 -> double: " + tooLateResult);
        System.out.println("double 9.0 / int 2 -> double: "
                + firstDoubleOperandResult);
        System.out.println("int 9 / double 2.0 -> double: "
                + secondDoubleOperandResult);
        System.out.println("(double) int 9 / int 2 -> double: " + castingResult);
    }
}
