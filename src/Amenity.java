public class Amenity {
    private String amenityName;
    private int cost;
    private int additionalGuests;

    public Amenity(String amenityName, int cost, int additionalGuests) {
        this.amenityName = amenityName;
        this.cost = cost;
        this.additionalGuests = additionalGuests;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getAdditionalGuests() {
        return additionalGuests;
    }

    public void setAdditionalGuests(int additionalGuests) {
        this.additionalGuests = additionalGuests;
    }
}