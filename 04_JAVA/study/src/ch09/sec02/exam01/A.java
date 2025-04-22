package ch09.sec02.exam01;

public class A {
//    default 생략-같은 패키지 내에서 사용 가능
//인스턴스 멤버 클래스
    class B {}

    B field=new B();

    A(){
        B b=new B();
    }
//인스턴스 메소드
    void method(){
        B b=new B();
    }


//     필드, 생성자, 메소드에서 B 객체 만들 수 있다
}
