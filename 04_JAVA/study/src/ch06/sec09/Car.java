package ch06.sec09;

public class Car {
    String model;
    int speed;

    public Car(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    void run(){
        this.setSpeed(100);
        System.out.println(model+"가 달립니다.(시속: "+getSpeed()+"km/h)");
    }
}
