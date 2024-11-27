
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String hotelName;
    private String location;
    private List <Cottage> cottageList = new ArrayList<>();
    private List <Amenity> allHotelAmenities = new ArrayList<>();

    public Hotel(String hotelName, String location, List<Cottage> cottageList, List<Amenity> allHotelAmenities) {
        this.hotelName = hotelName;
        this.location = location;
        this.cottageList = cottageList;
        this.allHotelAmenities = allHotelAmenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocations() {
        return location;
    }

    public void setLocations(String location) {
        this.location = location;
    }

    public List<Cottage> getCottageList() {
        return cottageList;
    }

    public void setCottageList(List<Cottage> cottageList) {
        this.cottageList = cottageList;
    }

    public List<Amenity> getAllHotelAmenities() {
        return allHotelAmenities;
    }

    public void setAllHotelAmenities(List<Amenity> allHotelAmenities) {
        this.allHotelAmenities = allHotelAmenities;
    }

    public void addAmenityIntoHotel(Amenity amenity) throws Exception{
        if(!isAmenityAlreadyInHotel(amenity)) {
            allHotelAmenities.add(amenity);
        } else {
            throw new Exception("This amenity is already in hotel, try again!");
        }
    }

    public boolean isAmenityAlreadyInHotel(Amenity amenity) {
        return allHotelAmenities.stream()
                .anyMatch(e -> e.getAmenityName().equals(amenity.getAmenityName()));
    }

    public void addCottageToHoselList(Cottage cottage) throws Exception{
        if(!isCottageInHotelList(cottage)) {
            cottageList.add(cottage);
        } else {
            throw new Exception("This cottage is already in hotel, try again!");
        }
    }

    public boolean isCottageInHotelList(Cottage cottage) {
        return cottageList.stream()
                .anyMatch(e -> e.equals(cottage));
    }

    public void printAllHotelCotages() {
        cottageList.forEach(e -> System.out.println("Cottage name: " + e.getCottageName() + ", category: " + e.getCategory()));
        cottageList.forEach(cottage -> {
            String amenitiesNames = cottage.getAmenities().stream()
                    .map(e -> e.getAmenityName())
                    .collect(Collectors.joining(", "));
            System.out.println("Cottage amenities: " + amenitiesNames);
        });
    }

    public void printAllHotelAmanities() {
        allHotelAmenities.forEach(e -> System.out.println("Amenity name: " + e.getAmenityName() + " cost: " + e.getCost()));
    }

    public List<Cottage> findCottagesByAmenity(Amenity amenity) {
        return cottageList.stream()
                .filter(cottage -> cottage.getAmenities().contains(amenity))
                .collect(Collectors.toList());
    }

    public int calculateTotalIncome() {
        return cottageList.stream()
                .mapToInt(Cottage::getRentalPrice)
                .sum();
    }

    public int calculateTotalExpenses() {
        return allHotelAmenities.stream()
                .mapToInt(Amenity::getCost)
                .sum();
    }

    public void printIncomeAndExpenseStatistics() {
        int totalIncome = calculateTotalIncome();
        int totalExpenses = calculateTotalExpenses();
        int profit = totalIncome - totalExpenses;

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Total Profit: " + profit);
    }
}