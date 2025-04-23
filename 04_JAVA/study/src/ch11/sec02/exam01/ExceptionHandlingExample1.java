package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data){
        int result = data.length();
        System.out.println("문자 수: " + result);
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);//NullPointerException 예외 발생(실행 예외)
        System.out.println("[프로그램 종료]");//예외 발생 후 코드 실행 X
    }
}
