package logicaloperator;

/**
 * AND·OR 논리 연산과 단락 평가의 동작을 확인하는 예제입니다.
 */
public class LogicalOperatorV1 {

    public static void main(String[] args) {
        /* &&(AND)는 두 피연산자가 모두 true일 때만 true입니다. */
        System.out.println("=== AND(&&) 진리표 ===");
        System.out.println("true  && true  -> " + (true && true));
        System.out.println("true  && false -> " + (true && false));
        System.out.println("false && true  -> " + (false && true));
        System.out.println("false && false -> " + (false && false));

        /* ||(OR)는 두 피연산자 중 하나 이상이 true이면 true입니다. */
        System.out.println();
        System.out.println("=== OR(||) 진리표 ===");
        System.out.println("true  || true  -> " + (true || true));
        System.out.println("true  || false -> " + (true || false));
        System.out.println("false || true  -> " + (false || true));
        System.out.println("false || false -> " + (false || false));

        /*
         * &&와 ||는 왼쪽 값만으로 전체 결과를 결정할 수 있으면 오른쪽을 실행하지 않습니다.
         * 이를 단락 평가(short-circuit evaluation)라고 합니다.
         * 아래 OR 식은 왼쪽이 이미 true이므로 0으로 나누는 오른쪽 식을 평가하지 않습니다.
         */
        int number = 1;
        int zero = 0;
        boolean safeOrResult = number < 5 || (10 / zero) > 1;

        /*
         * 아래 AND 식은 text가 null이므로 왼쪽이 false입니다.
         * 오른쪽의 text.length()를 호출하지 않아 NullPointerException이 발생하지 않습니다.
         * null 확인은 반드시 객체의 메서드를 호출하기 전에 작성해야 합니다.
         */
        String text = null;
        boolean safeAndResult = text != null && text.length() > 3;

        System.out.println();
        System.out.println("=== 단락 평가 ===");
        System.out.println("OR 단락 평가 결과: " + safeOrResult);
        System.out.println("AND 단락 평가 결과: " + safeAndResult);

        // 순서를 바꾸면 위험한 식을 먼저 평가하므로 예외가 발생합니다.
        // boolean unsafeOrResult = (10 / zero) > 1 || number < 5;
        // boolean unsafeAndResult = text.length() > 3 && text != null;
    }
}
