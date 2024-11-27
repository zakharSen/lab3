import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class Cottage {
    private String cottageName;
    private String category;
    private List<Amenity> amenities = new ArrayList<>();
    private int maxGuests;
    private List<Booking> bookings = new ArrayList<>();
    private final int rentalPrice;

    public Cottage(String cottageName, String category, List<Amenity> amenities, int maxGuests, List<Booking> bookings, int rentalPrice) {
        this.cottageName = cottageName;
        this.category = category;
        this.amenities = amenities;
        this.maxGuests = maxGuests;
        this.bookings = bookings;
        this.rentalPrice = rentalPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public String getCottageName() {
        return cottageName;
    }

    public void setCottageName(String cottageName) {
        this.cottageName = cottageName;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addAmenityIntoCottageList(Amenity amenity) throws Exception {
        amenities.add(amenity);
    }


    public int calculateTotalCost() {
        return amenities.stream().mapToInt(Amenity::getCost).sum();
    }

    public int calculateDiscountedCost() {
        int cost = calculateTotalCost();
        Calendar currentDate = Calendar.getInstance();
        int month = currentDate.get(Calendar.MONTH);
        if (month == Calendar.NOVEMBER || month == Calendar.MARCH) {
            return (int) (cost * 0.8);
        }
        return cost;
    }

    public void addBooking(Booking booking) throws Exception {
        if (isCottageAvailable(booking.getStartDate(), booking.getEndDate())) {
            bookings.add(booking);
        } else {
            throw new Exception("Cottage is not available for the selected dates.");
        }
    }

    public boolean isCottageAvailable(Calendar startDate, Calendar endDate) {
        return bookings.stream().noneMatch(booking ->
                startDate.before(booking.getEndDate()) && endDate.after(booking.getStartDate())
        );
    }

    public void printAllCottageAmanities() {
        amenities.forEach(e -> System.out.println("Amenity name: " + e.getAmenityName() + " cost: " + e.getCost()));
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

}