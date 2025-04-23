package calInterface;

public interface calculatorInteface {

    //커스텀 목표 : 결합도 생각(추상,상속 등), 키 바인딩 사용 ( IDE에서 press 이벤트 지원불가 이슈)

    //트러블 슈팅 : 패키지 아래에 인터페이스를 두는게 아닌 프로젝트 루트 디렉토리 바로 아래에 공통인터페이스를 생성하여 다른 패키지에서 구현 불가 -> 인터페이스용 패키지 생성

    /* 키바인딩이 안되어 사용안하기로함..
    public static final String[] type = {"+", "-", "/", "*"};*/

    // 덧셈

    int add(int a, int b);

    // 뺄셈
    int subtract(int a, int b);

    // 곱셈
    int multiply(int a, int b);

    // 나눗셈
    int divide(int a, int b) throws ArithmeticException;

    // 결과
    int result();
}
