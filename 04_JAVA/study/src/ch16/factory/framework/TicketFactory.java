package ch16.factory.framework;

public abstract class TicketFactory {
    public final Ticket create(String owner){
        Ticket ticket = createTicket(owner);
        registerTicket(ticket);
        return ticket;
    }
    protected abstract Ticket createTicket(String owner);
    protected abstract void registerTicket(Ticket ticket);
}
