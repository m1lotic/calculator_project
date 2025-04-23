package level3;

public enum operatorType { //값의 집합 (상수 등) 내 입맛대로 사칙연산 관리

    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char type;

    // 연산자의 심볼을 관리
    operatorType(char type) {
        this.type = type;
    }

    // 연산자의 심볼을 반환
    public char getType() {
        return this.type;
    }

    // 연산자에 따른 실제 계산을 수행하는 메서드
    public int calculate(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("0으로 나누기 불가능.");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("지원되지 않는 연산자");
        }
    }

    public double calculate(double a, double b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("0으로 나누기 불가능.");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("지원되지 않는 연산자");
        }
    }

}
