package ch07.sec04.exam01;

public class Computer extends Calculator{
//    @Override: 컴파일 시 오버라이딩을 체크해주기 때문에 권장사항
    @Override
    public double areaCircle(double r){
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI*r*r;

    }

}
