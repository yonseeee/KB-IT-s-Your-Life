package ch06.sec08.exam04;

public class Calculator {

    double areaRectangle(int a){
        return a*a;
    }
//    메소드 오버로딩: 메소드 이름은 같지만 매개변수의 개수가 다르다
    double areaRectangle(int a,int b){
        return a*b;
    }
}
