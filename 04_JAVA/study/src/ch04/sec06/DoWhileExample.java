package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메시지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String inputString;

        do{//while 문 안의 조건이 false여도 무조건 한번은 실행
            System.out.println(">");
            inputString = sc.nextLine();
            System.out.println(inputString);//사용자가 입력한 값 그대로 출력
        }while(!inputString.equals("q"));//사용자가 입력한 값이 q일때까지 반족

        System.out.println();
        System.out.println("프로그램 종료");

    }
}
