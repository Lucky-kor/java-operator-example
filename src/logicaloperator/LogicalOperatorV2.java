package logicaloperator;

/**
 * NOT 논리 연산과 드모르간 법칙을 확인하는 예제입니다.
 */
public class LogicalOperatorV2 {

    public static void main(String[] args) {
        /*
         * !(NOT)은 boolean 값을 반대로 바꿉니다.
         * true는 false가 되고 false는 true가 됩니다.
         */
        boolean isLoggedIn = true;
        boolean isLoggedOut = !isLoggedIn;

        int age = 18;
        boolean isMinor = !(age >= 19);

        System.out.println("=== NOT(!) 연산 ===");
        System.out.println("로그인 상태: " + isLoggedIn);
        System.out.println("로그아웃 상태: " + isLoggedOut);
        System.out.println("나이: " + age);
        System.out.println("미성년자인가? " + isMinor);

        /*
         * 부정을 두 번 적용하면 원래 값으로 돌아옵니다.
         * 문법적으로 !를 여러 번 쓸 수 있지만 의미가 불분명해지므로 간단히 작성합니다.
         */
        boolean originalValue = true;
        boolean doubleNegation = !!originalValue;

        System.out.println();
        System.out.println("이중 부정 결과: " + doubleNegation); // true

        /*
         * 드모르간 법칙에 따라 !(A && B)는 !A || !B와 같고,
         * !(A || B)는 !A && !B와 같습니다.
         */
        boolean hasIdCard = true;
        boolean hasTicket = false;
        boolean cannotEnter = !(hasIdCard && hasTicket);
        boolean sameMeaning = !hasIdCard || !hasTicket;

        System.out.println();
        System.out.println("=== 드모르간 법칙 ===");
        System.out.println("!(신분증 있음 && 입장권 있음): " + cannotEnter);
        System.out.println("신분증 없음 || 입장권 없음: " + sameMeaning);
        System.out.println("두 식의 결과가 같은가? " + (cannotEnter == sameMeaning));
    }
}
