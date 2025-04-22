package ch09.sec07.exam02;

public class Home {
//    익명 구현 객체: 인터페이스 구현
    private RemoteControl rc=new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };

//    1번 방법. 필드 이용
    public void use1(){
        rc.turnOn();
        rc.turnOff();
    }

//    2번 방법. 로컬 변수 이용
    public void use2(){
        RemoteControl rc=new RemoteControl() {
            @Override
            public void turnOn(){
                System.out.println("에어컨을 켭니다.");
            }
            @Override
            public void turnOff(){
                System.out.println("에어컨을 끕니다.");
            }
        };
        rc.turnOn();
        rc.turnOff();
    }

//    3번 방법.
    public void use3(RemoteControl rc){
        rc.turnOn();
        rc.turnOff();
    }
}
