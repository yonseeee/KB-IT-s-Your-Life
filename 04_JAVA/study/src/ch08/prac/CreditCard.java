package ch08.prac;

public class CreditCard implements Payment{

    private int amount;
    @Override
    public boolean pay(int amount) {
        this.amount = amount;
                System.out.println("[신용카드] " +amount+"원 결제 완료");
        Payment.log("결제 수단: [CreditCard], 금액: "+amount+"원");

        return true;
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[신용카드] " +this.amount+"원 결제 취소 - 사유: "+reason);
    }

}
