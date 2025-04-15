package prac;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int total=0;
        while (true){
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.print("선택> ");
            int n=sc.nextInt();
            switch (n){
                case 1:
                    System.out.print("예금액>");
                    int amount=sc.nextInt();
                    total+=amount;
                    break;
                case 2:
                    System.out.print("출금액>");
                    int amount1=sc.nextInt();
                    total-=amount1;
                    break;
                case 3:
                    System.out.print("잔고>");
                    System.out.println(total);
                    break;
                default:
                    System.out.println("프로그램 종료");
                    break;
            }
            if(n==4){
                break;
            }
        }
    }
}
