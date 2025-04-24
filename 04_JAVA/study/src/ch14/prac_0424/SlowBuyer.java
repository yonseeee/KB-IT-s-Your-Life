package ch14.prac_0424;

public class SlowBuyer implements TicketBuyer{
    @Override
    public void buyTicket() {

    }

    @Override
    public void waitTurn() {
        try{
//            System.out.println("slow");
            Thread.sleep(200);
        }catch (InterruptedException e){}
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println(name+": 처음이라 떨려요...입장 완료!");
    }
}
