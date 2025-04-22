package ch08.prac;

import java.util.ArrayList;

public class PaymentManager {
    private static int count = 0;
    private static int total=0;
    private static int isKaKaoPay = 0;
    private static int isCreditCardPay = 0;

    private ArrayList<Payment> payments = new ArrayList<Payment>();
    public void process(Payment p, int amount){
        if(p.beforePay()){
            if(p.pay(amount)){
                p.approve();
                p.cancel("테스트 취소");
                if(p instanceof KakaoPay){
                    ((KakaoPay) p).sendNotification();
                    isKaKaoPay++;
                }else{
                    isCreditCardPay++;
                    System.out.println("[알림 서비스 없음]");
                }
                total+=amount;
            }
            else{
                return;
            }
        }
        else{
            return;
        }
    }
    public void printSummary(){
        int count=isCreditCardPay+isKaKaoPay;
        System.out.println();
        System.out.println("✅ 결제 통계 요약");
        System.out.println("총 결제 횟수: "+count+"회");
        System.out.println("총 결제 금액: "+total+"원");
        System.out.println("[CreditCard]: "+isCreditCardPay+"건");
        System.out.println("[KaKaoPay]: "+isKaKaoPay+"건");
    }
}
