package ch06.sec14;

public class Car {
    private int speed;
    private boolean stop;

    //습관적으로 기본 생성자와 모든 변수 받는 생성자 만들기
    public Car() {
    }

    public Car(boolean stop, int speed) {
        this.stop = stop;
        this.speed = speed;
    }

//    Getter: 값 읽는 용도(가져오기)
    public int getSpeed(){
        return speed;
    }

//    Setter: 값을 설정하는 용도
    public void setSpeed(int speed){
        if(speed<0){
            this.speed=0;
        }else{
            this.speed = speed;
        }
    }
    public boolean isStop(){
        return stop;
    }
    public void setStop(boolean stop){
        this.stop = stop;
        if(stop){this.speed=0;}
    }
}
