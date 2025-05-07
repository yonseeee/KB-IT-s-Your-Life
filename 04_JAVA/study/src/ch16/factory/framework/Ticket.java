package ch16.factory.framework;

public abstract class Ticket {
    private final String owner;

    public Ticket(String owner) {
        this.owner = owner;
    }
    public abstract void enter();

    @Override
    public String toString() {
        return "[MetaMonTicket:"+owner+"]";
    }
}
