import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel 1", "Lviv", new ArrayList<>(), new ArrayList<>());

        Amenity sofaAmenity = new Amenity("Sofa", 100, 2);
        Amenity spaAmenity = new Amenity("Spa", 300, 0);
        Amenity wifiAmenity = new Amenity("WIFI", 50, 0);
        Amenity kitchenAmenity = new Amenity("Kitchen", 200, 1);
        Amenity bedAmenity = new Amenity("Bed", 150, 1);

        try {
            hotel.addAmenityIntoHotel(sofaAmenity);
            hotel.addAmenityIntoHotel(wifiAmenity);
            hotel.addAmenityIntoHotel(spaAmenity);
            hotel.addAmenityIntoHotel(kitchenAmenity);
            hotel.addAmenityIntoHotel(bedAmenity);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("All hotel amenities:");
        hotel.printAllHotelAmanities();

        List<Amenity> initialCottageAmenities = new ArrayList<>();
        try {
            initialCottageAmenities.add(bedAmenity);
            initialCottageAmenities.add(wifiAmenity);
            initialCottageAmenities.add(spaAmenity);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Cottage cottage = new Cottage("Cottage 1", "Lux", initialCottageAmenities, 3, new ArrayList<>(), 1000);

        try {
            hotel.addCottageToHoselList(cottage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        hotel.printAllHotelCotages();



        System.out.println("Enter your first name:");
        String customerFirstName = scanner.nextLine();
        System.out.println("Enter your second name:");
        String customerLastName = scanner.nextLine();
        Customer customer = new Customer(customerFirstName, customerLastName, new ArrayList<>());

        System.out.println("Enter start date for booking (day month):");
        int startDay = Integer.parseInt(scanner.nextLine());
        int startMonth = Integer.parseInt(scanner.nextLine()) - 1;
        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.DAY_OF_MONTH, startDay);
        startDate.set(Calendar.MONTH, startMonth);
        startDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

        System.out.println("Enter end date for booking (day month):");
        int endDay = Integer.parseInt(scanner.nextLine());
        int endMonth = Integer.parseInt(scanner.nextLine()) - 1;
        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.DAY_OF_MONTH, endDay);
        endDate.set(Calendar.MONTH, endMonth);
        endDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));

        try {
            Booking booking = new Booking(customer, startDate, endDate);
            customer.addCustomerNewBooking(booking);
            System.out.println("Booking successfully added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        customer.printAllCustomerBookings();

        System.out.println("Would you like to add more amenities to the cottage? (yes/no)");
        String response = scanner.nextLine();

        System.out.println("Would you like to know the discounted cost for booking in November or March?");
        String discountResponse = scanner.nextLine();
        if (discountResponse.equalsIgnoreCase("yes")) {
            int discountedCost = cottage.calculateDiscountedCost();
            System.out.println("Discounted cost for amenities in cottage is: " + discountedCost);
        } else {
            System.out.println("Total cost without discount: " + cottage.calculateTotalCost());
        }

        if (response.equalsIgnoreCase("yes")) {
            while (true) {
                System.out.println("Available amenities:");
                hotel.getAllHotelAmenities().forEach(amenity -> System.out.println(amenity.getAmenityName()));

                System.out.println("Enter the name of the amenity you want to add (or type 'exit' to finish):");
                String amenityName = scanner.nextLine();

                if (amenityName.equalsIgnoreCase("exit")) {
                    System.out.println("Your cottage amenities: " );
                    cottage.printAllCottageAmanities();
                    break;
                }

                Amenity amenityToAdd = hotel.getAllHotelAmenities().stream()
                        .filter(amenity -> amenity.getAmenityName().equalsIgnoreCase(amenityName))
                        .findFirst()
                        .orElse(null);

                if (amenityToAdd != null) {
                    try {
                        cottage.addAmenityIntoCottageList(amenityToAdd);
                        System.out.println(amenityName + " has been added to the cottage.");
                    } catch (Exception e) {
                        System.out.println("Error adding amenity: " + e.getMessage());
                    }
                } else {
                    System.out.println("Amenity not found. Please try again.");
                }
            }
        }
        hotel.printIncomeAndExpenseStatistics();
    }
}