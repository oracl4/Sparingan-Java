package sparingan_java;

public enum Sport {
    BASKETBALL("Basketball"),
    FUTSAL("Futsal"),
    BADMINTON("Badminton"),
    BASEBALL("Baseball"),
    SOFTBALL("Softball");

    private String sport;
    Sport(String sport){
        this.sport = sport;
    }
    public String toString(){
        return sport;
    }
}
