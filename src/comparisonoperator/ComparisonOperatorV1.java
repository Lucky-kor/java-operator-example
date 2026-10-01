package comparisonoperator;

/**
 * 비교 연산자의 종류와 비교 결과의 활용 방법을 확인하는 예제입니다.
 */
public class ComparisonOperatorV1 {

    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 3;

        /*
         * 비교 연산은 두 값을 비교하고 항상 boolean 값인 true 또는 false를 반환합니다.
         * ==는 같은지, !=는 다른지를 확인합니다. 대입 연산자 =와 혼동하지 않습니다.
         */
        boolean isGreater = firstNumber > secondNumber;
        boolean isGreaterOrEqual = firstNumber >= secondNumber;
        boolean isLess = firstNumber < secondNumber;
        boolean isLessOrEqual = firstNumber <= secondNumber;
        boolean isEqual = firstNumber == secondNumber;
        boolean isNotEqual = firstNumber != secondNumber;

        System.out.println("=== 비교 연산 ===");
        System.out.println("5 > 3: " + isGreater);
        System.out.println("5 >= 3: " + isGreaterOrEqual);
        System.out.println("5 < 3: " + isLess);
        System.out.println("5 <= 3: " + isLessOrEqual);
        System.out.println("5 == 3: " + isEqual);
        System.out.println("5 != 3: " + isNotEqual);

        /*
         * 자바에서는 1 < value < 5처럼 비교 연산자를 이어 쓸 수 없습니다.
         * 두 비교식을 각각 작성한 뒤 &&로 연결해야 값이 범위 안에 있는지 확인할 수 있습니다.
         */
        int value = 3;
        boolean isBetweenOneAndFive = 1 < value && value < 5;

        System.out.println();
        System.out.println("=== 범위 확인 ===");
        System.out.println("값: " + value);
        System.out.println("1보다 크고 5보다 작은가? " + isBetweenOneAndFive);
    }
}
