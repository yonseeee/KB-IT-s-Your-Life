package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa=new SupersonicAirplane();
        sa.takeoff();//자식 클래스가 갖고 있지 않은 메소드는 부모 메소드
        sa.fly();
        sa.flyMode=SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode=SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
