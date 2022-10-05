package immutability;

public class Address {
    private String streetAddress;
    private String city;

    public Address(String streetAddress, String city) {
        this.streetAddress = streetAddress;
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address={" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
