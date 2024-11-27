import java.util.Calendar;

public class Booking {
    private Customer customer;
    private Calendar startDate;
    private Calendar endDate;

    public Booking(Customer customer, Calendar startDate, Calendar endDate) {
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}