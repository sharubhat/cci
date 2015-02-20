package threads.concurrency_cookbook.chapter2._2_independent_attributes;

/**
 * Created by sharath on 1/31/15.
 */
public class Cinema {
    private long vacanciesCinema_1, vacanciesCinema_2;
    private final Object controlCinema_1, controlCinema_2;

    public Cinema() {
        this.vacanciesCinema_1 = 20;
        this.vacanciesCinema_2 = 20;
        this.controlCinema_1 = new Object();
        this.controlCinema_2 = new Object();
    }

    public boolean sellTickets_1(int number) {
        synchronized (controlCinema_1) {
            if(number < vacanciesCinema_1) {
                vacanciesCinema_1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets_2(int number) {
        if(number < vacanciesCinema_2) {
            vacanciesCinema_2 -= number;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnTickets_1(int number) {
        synchronized (controlCinema_1) {
            vacanciesCinema_1 +=number;
            return true;
        }
    }

    public boolean returnTickets_2(int number) {
        synchronized (controlCinema_2) {
            vacanciesCinema_2 += number;
            return true;
        }
    }

    public long getVacanciesCinema_1() {
        return vacanciesCinema_1;
    }

    public long getVacanciesCinema_2() {
        return vacanciesCinema_2;
    }
}
