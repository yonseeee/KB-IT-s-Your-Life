package ch06.sec10.exam01;

public class Calculator {
    //static이 붙으면 해당 클래스로 만든 모든 객체들이 해당 데이터 공유
    static double pi = 3.14159;

    static int plus(int x, int y) {
        return x + y;
    }

    static int minus(int x, int y) {
        return x - y;
    }
}
