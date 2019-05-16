package sparingan_java;

public enum UserType {
    SOLO("Team"),
    TEAM("Solo");

    private String userType;

    UserType(String userType){
        this.userType = userType;
    }
    public String toString(){
        return userType;
    }
}

