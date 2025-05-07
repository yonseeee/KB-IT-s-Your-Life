package ch16.sec05.exam01;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

//        정적 메소드일 경우
//        1. 람다식 사용
        person.action((x,y)->Computer.staticMethod(x, y));
//        2. 메소드 참조: 앞부분은 클래스명으로 접근
        person.action(Computer::staticMethod);


//        인스턴스 메소드일 경우
        Computer computer = new Computer();
//        1. 람다식 사용
        person.action((x,y)-> computer.instanceMethod(x,y));
//        2. 메소드 참조: 앞부분은 참조 변수로 접근
        person.action(computer::instanceMethod);
    }
}
