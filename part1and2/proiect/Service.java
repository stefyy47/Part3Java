package part1and2.proiect;

public interface Service {
    int buyTicket(Hall h);
    int buyTicket(Hall h, int place);
    int sellTicket(Hall h, Customer c);
}
