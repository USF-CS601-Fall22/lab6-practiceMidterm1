package solution.immutability;

// This class is immutable - read comments to understand the changes
public final class Hotel { // made final so that no one can extend it
    private final String hotelName; // made variables final
    private final String hotelId;
    private final Address address;

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

    // Address is mutable so need to create and return a copy.
    public Address getAddress() { return new Address(address.getStreetAddress(), address.getCity()); }

    // Need to remove the setter. Can't have setters in immutable classes - the attributes are final, so cannot change.
    /* public void setAddress(Address newAddress) {
        this.address = address;
    }
    */


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
