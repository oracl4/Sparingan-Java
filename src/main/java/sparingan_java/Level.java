package sparingan_java;

public enum Level {
    BEGINNER("BEGINNER"),
    MODERATE("MODERATE"),
    ELITE("ELITE");

    private String level;

    Level(String level)
    {
        this.level = level;
    }

    public String toString()
    {
        return level;
    }
}
