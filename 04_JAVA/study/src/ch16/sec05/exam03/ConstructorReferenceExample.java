package ch16.sec05.exam03;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person=new Person();

//        매개변수 1개 생성자 참조
        Member m1=person.getMember1(Member::new);
        System.out.println(m1);
        System.out.println();

//        매개변수 2개 생성자 참조
        Member m2=person.getMember2(Member::new);
        System.out.println(m2);
    }
}
