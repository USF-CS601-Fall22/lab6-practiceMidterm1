package immutability;

import com.google.gson.annotations.SerializedName;

// FILL IN CODE: make the class immutable
public class Hotel {
    private String hotelName;
    private String hotelId;
    private Address address;

    /**
     * Constructor to set values of the variables
     * @param hotelName
     * @param hotelId
     * @param address
     */
    public Hotel(String hotelName, String hotelId, Address address) {
        this.hotelName = hotelName;
        this.hotelId = hotelId;
        this.address = address;
    }

    /**
     * @return hotelId.
     */
    public String getHotelId() {
        return hotelId;
    }

    public Address getAddress() { return address; }

    /**
     * Set the new address
     * @param newAddress
     */
    public void setAddress(Address newAddress) {
        this.address = address;
    }

    /**
     * @return a string representing the hotel
     */
    @Override
    public String toString() {
        return  "hotelName=" + hotelName + System.lineSeparator() +
                "hotelId=" + hotelId + System.lineSeparator() +
                 address.toString();
    }

}
