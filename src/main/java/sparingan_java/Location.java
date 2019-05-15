package sparingan_java;

public enum Location {
    JAKARTA("Jakarta"),
    DEPOK("Depok"),
    BOGOR("Bogor"),
    BANDUNG("Bandung");

    private String location;

    Location(String location){
        this.location = location;
    }
    public String toString(){
        return location;
    }
}
