package calInterface;

public interface calculatorInterfaceGeneric<T extends Number> {

    //트?러?블 슈팅 : 아 어떻게든 공용 인터페이스 하나만 두고 싶었는데 래퍼 클래스 사용하면 연산 성능저하 와서 제너릭 전용 인터페이스 하나 더 만듬

    // 덧셈
    T add(T a, T b);

    // 뺄셈
    T subtract(T a, T b);

    // 곱셈
    T multiply(T a, T b);

    // 나눗셈
    T divide(T a, T b) throws ArithmeticException;

    // 결과
    T result();

}
