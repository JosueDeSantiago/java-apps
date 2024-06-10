package gto.tech.talent.address;

public class Address {
    // Propiedades
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private int id;

    // Constructor
    public Address(String street, String city, String state, String zip, String country, int id) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.id = id;
    }

    // Getters y setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método estático setId que regresa id + 1
    public static int setIdMasUno(int id) {
        return id + 1;
    }

    // Sobrescribir método toString
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", id=" + id +
                '}';
    }
}

