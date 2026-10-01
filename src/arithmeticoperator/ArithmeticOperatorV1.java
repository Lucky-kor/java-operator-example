package arithmeticoperator;

/**
 * 정수의 기본 산술 연산과 연산자 우선순위를 확인하는 예제입니다.
 */
public class ArithmeticOperatorV1 {

    public static void main(String[] args) {
        int firstNumber = 7;
        int secondNumber = 2;

        /*
         * +, -, *, /, %는 각각 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산자입니다.
         * 두 피연산자가 모두 int이면 결과도 int입니다.
         */
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int product = firstNumber * secondNumber;
        int quotient = firstNumber / secondNumber;
        int remainder = firstNumber % secondNumber;

        System.out.println("=== 정수의 산술 연산 ===");
        System.out.println("7 + 2 = " + sum);        // 9
        System.out.println("7 - 2 = " + difference); // 5
        System.out.println("7 * 2 = " + product);    // 14
        System.out.println("7 / 2 = " + quotient);   // 3
        System.out.println("7 % 2 = " + remainder);  // 1

        /*
         * 정수끼리 나누면 소수 부분을 버린 정수 몫만 남습니다.
         * 나머지 연산은 어떤 수가 다른 수로 나누어떨어지는지 확인할 때 유용합니다.
         */
        boolean isEven = firstNumber % 2 == 0;

        System.out.println();
        System.out.println("7은 짝수인가? " + isEven);

        /*
         * 곱셈·나눗셈·나머지는 덧셈·뺄셈보다 먼저 계산됩니다.
         * 계산 순서를 명확히 나타내거나 바꾸려면 괄호를 사용합니다.
         */
        int withoutParentheses = 2 + 3 * 4;
        int withParentheses = (2 + 3) * 4;

        System.out.println();
        System.out.println("=== 연산자 우선순위 ===");
        System.out.println("2 + 3 * 4 = " + withoutParentheses);   // 14
        System.out.println("(2 + 3) * 4 = " + withParentheses);    // 20
    }
}
