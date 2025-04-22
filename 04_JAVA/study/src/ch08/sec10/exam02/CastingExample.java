package ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();//업캐스팅(=자동타입변환)

        vehicle.run();//자식 클래스의 run 호출
//        vehicle.checkFare(); //부모에 없는 메소드기 때문에 불가능
        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }
}
