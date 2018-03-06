package chapter2;

public class StreetAddress {
    int number;
    String street;
    String city;
    String state;
    int zipCode;

    StreetAddress(int number, String street, String city, String state,
                  int zipCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "" + number + " " + street + " " + city + " " + state + " " +
                zipCode;
    }
}
