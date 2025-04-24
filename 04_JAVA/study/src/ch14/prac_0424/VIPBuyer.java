package ch14.prac_0424;

public class VIPBuyer implements TicketBuyer{
    @Override
    public void buyTicket() {


    }

    @Override
    public void waitTurn() {
        try{
//            System.out.println("vip");
            Thread.sleep(10);
        }catch (InterruptedException e){}
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println("VIP "+name+" 입장 완료!");
    }
}
