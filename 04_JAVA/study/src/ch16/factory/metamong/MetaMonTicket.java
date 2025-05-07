package ch16.factory.metamong;

import ch16.factory.framework.Ticket;

public class MetaMonTicket extends Ticket {
    private String owner;
    public MetaMonTicket(String owner) {
        super(owner);
        System.out.println(owner+"님의 메타몽 티켓을 발급합니다.");
    }
    public void enter(){
        System.out.println(this +"님이 입장하였습니다.");

    }
}
