package threads.concurrency_cookbook.chapter2._2_independent_attributes;

/**
 * Created by sharath on 1/31/15.
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice_1 ticketOffice_1 = new TicketOffice_1(cinema);
        Thread t1 = new Thread(ticketOffice_1);

        TicketOffice_2 ticketOffice_2 = new TicketOffice_2(cinema);
        Thread t2 = new Thread(ticketOffice_2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema_1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema_2());
    }
}
