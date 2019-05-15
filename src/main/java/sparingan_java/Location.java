package sparingan_java;

public class Location {
    public String city, name;
    public Sport sport;

    public Location(String city, String name, Sport sport) {
        this.city = city;
        this.name = name;
        this.sport = sport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
