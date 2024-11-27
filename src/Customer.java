import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private List<Booking> customerBookings = new ArrayList<>();

    public Customer(String firstName, String lastName, List<Booking> customerBookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerBookings = customerBookings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Booking> getCustomerBookings() {
        return customerBookings;
    }

    public void setCustomerBookings(List<Booking> customerBookings) {
        this.customerBookings = customerBookings;
    }

    public void addCustomerNewBooking(Booking booking) throws Exception{
        if(!isBookingInBookingList(booking)) {
            customerBookings.add(booking);
        } else {
            throw new Exception("This booking is already in customer booking list, try again");
        }
    }

    public boolean isBookingInBookingList(Booking booking) {
        return customerBookings.stream()
                .anyMatch(e -> e.equals(booking));
    }

    public void printAllCustomerBookings() {
        customerBookings.forEach(e -> {
            System.out.println("Bookings: " + e.getCustomer().getFirstName() + " " + e.getCustomer().getLastName()
                    + " Start Date: " + e.getStartDate().get(Calendar.DAY_OF_MONTH) + "-"
                    + (e.getStartDate().get(Calendar.MONTH) + 1) + "-"
                    + e.getStartDate().get(Calendar.YEAR)
                    + " End Date: " + e.getEndDate().get(Calendar.DAY_OF_MONTH) + "-"
                    + (e.getEndDate().get(Calendar.MONTH) + 1) + "-"
                    + e.getEndDate().get(Calendar.YEAR));
        });
    }

}