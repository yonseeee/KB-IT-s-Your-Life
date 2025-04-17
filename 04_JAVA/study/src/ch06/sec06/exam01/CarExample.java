package ch06.sec06.exam01;

public class CarExample {
    public static void main(String[] args) {
//        Car 객체 생성
        Car myCar=new Car();
//초기화를 안했을 경우 기본값이 할당
        System.out.println(myCar.model);
        System.out.println(myCar.start);
        System.out.println(myCar.speed);
    }
}
