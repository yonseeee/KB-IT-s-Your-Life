package ch16.test;


public class LambdaExample {
    public static void main(String[] args) {
        Calcuable calculable = (x,y)->x+y;
        int result=calculable.calc(5,3);
        System.out.println(result);
    }
}
