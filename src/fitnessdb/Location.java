package fitnessdb;

public enum Location {
    BRIDGEWATER ("08807", "SomersetCounty"),
    EDISON ( "08837", "Middlesex County"),
    FRANKLIN ("08873", "Somerset County"),
    PISCATAWAY ("08854","Somerset County" ),
    SOMERVILLE("08876","Somerset County");

    private final String zipCode; 
    private final String county; 

    Location(String zipcode, String county){
        this.zipCode = zipcode; 
        this.county = county; 
    }

    public String getZipCode(){
        return this.zipCode; 
    }

    public String getCounty(){
        return this.county; 
    }
}

