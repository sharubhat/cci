package threads.concurrency_cookbook.chapter2._2_independent_attributes;

/**
 * Created by sharath on 1/31/15.
 */
public class TicketOffice_1 implements Runnable {
    private Cinema cinema;

    public TicketOffice_1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets_1(3);
        cinema.sellTickets_1(2);
        cinema.sellTickets_2(2);
        cinema.returnTickets_1(3);
        cinema.sellTickets_1(5);
        cinema.sellTickets_2(2);
        cinema.sellTickets_2(2);
        cinema.sellTickets_2(2);
    }
}
