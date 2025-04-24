package ch14.prac_0424;

public class RegularBuyer implements TicketBuyer{
    @Override
    public void buyTicket() {

    }

    @Override
    public void waitTurn() {
        try{
//            System.out.println("regular");
            Thread.sleep(100);
        }catch (InterruptedException e){}
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println(name+" 입장 완료!");
    }
}
