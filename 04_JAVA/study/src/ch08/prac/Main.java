package ch08.prac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.println("[0] 종료");
            System.out.print("결제 수단을 선택하세요: ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            Payment p=null;
            PaymentManager pm=new PaymentManager();


            if(choice==1){
                p=new CreditCard();
            }
            else if(choice==2){
                p=new KakaoPay();
                System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
                char ch = sc.next().charAt(0);
                if (ch == 'y') {
                    ((KakaoPay) p).authenticate();
                }
            }
            else{
                pm.printSummary();
                break;
            }

            if(p.beforePay()){
                System.out.print("결제 금액을 입력하세요: ");
                int amount = sc.nextInt();
                pm.process(p,amount);
            }
            else{
                System.out.println("[결제 실패: 준비 단계에서 중단]");

            }
            System.out.println();
        }

//        Payment payment = new CreditCard();
//        payment.pay(5000);
//        payment.approve();
//        payment.cancel("단순 변심");


//        Payment payment = new KakaoPay();
//        payment.pay(3000);       // 실패 케이스
//        payment.pay(7000);       // 성공 케이스
//        payment.approve();
//        payment.cancel("오입력");

//        System.out.print("선택: ");
//        Scanner sc = new Scanner(System.in);
//        int option=sc.nextInt();
//        Payment p=null;
//        if(option==1){
//            p=new CreditCard();
//        }else if(option==2){
//            p= new KakaoPay();
//        }
//
//        System.out.print("금액: ");
//        int amount=sc.nextInt();
//        if(p.pay(amount)){
//            p.approve();
//            p.cancel("테스트 취소");
//
//            if(p instanceof KakaoPay){
//                ((KakaoPay) p).sendNotification();
//            }else{
//                System.out.println("[알림 서비스 없음]");
//            }
//        }else{
//            System.out.println("[결제 실패: 승인/취소 건너뜀]");
//        }
//        Payment[] payments = {
//                new CreditCard(),
//                new KakaoPay(),
//                new KakaoPay(),
//                new CreditCard()
//        };
//
//        for(int i=0;i<payments.length;i++){
//            System.out.println("["+(i+1)+"번 결제수단] 결제 금액을 입력하세요:");
//            System.out.print(">> ");
////            Scanner sc=new Scanner(System.in);
//            int amount=sc.nextInt();
//            boolean result= payments[i].pay(amount);
//            if(result==true){
//                payments[i].approve();
//                payments[i].cancel("테스트 취소");
//            }
//            else
//            {
//                System.out.println("[결제 실패: 승인/취소 건너뜀");
//            }
//            System.out.println();
//        }





//        if(choice==2){
//            p=new KakaoPay();
//            System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
//            char ch=sc.next().charAt(0);
//            if(ch=='y'){
//                ((KakaoPay)p).authenticate();
//                p.beforePay();
//                System.out.print("결제 금액을 입력하세요: ");
//                int amount=sc.nextInt();
//                if(p.pay(amount)){
//                    p.approve();
//                    p.cancel("테스트 취소");
//                    ((KakaoPay) p).sendNotification();
//                }else{
//                    System.out.println("[결제 실패: 승인/취소 건너뜀]");
//                }
//            }else if(ch=='n'){
//                p.beforePay();
//                System.out.println("[결제 실패: 준비 단계에서 중단]");
//            }
//        }else if(choice==1){
//            p=new CreditCard();
//            p.beforePay();
//            System.out.print("결제 금액을 입력하세요: ");
//            int amount1=sc.nextInt();
//            if(p.pay(amount1)){
//                p.approve();
//                p.cancel("테스트 취소");
//            }
//            System.out.println("[알림 서비스 없음]");
//
//        }
    }
}