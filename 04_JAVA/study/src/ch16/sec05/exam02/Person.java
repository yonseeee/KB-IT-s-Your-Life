package ch16.sec05.exam02;

public class Person {
    public void ordering(Comparable comparable) {
        String a="홍길동";
        String b="김길동";

        int result=comparable.compare(a,b);

        if(result<0){
            System.out.println();
        }else if(result==0){
            System.out.println();
        }else{
            System.out.println();
        }
    }
}
