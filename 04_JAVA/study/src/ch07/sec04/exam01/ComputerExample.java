package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r=10;

        Calculator calc=new Calculator();
        System.out.println("원 면적: "+calc.areaCircle(r));
        System.out.println();

        Computer computer=new Computer();
//        자식 객체의 경우 오버라이딩한 메소드를 우선시한다.
        System.out.println("원 면적: "+computer.areaCircle(r));
    }
}
