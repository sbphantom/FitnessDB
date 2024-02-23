/**
 * Enum class defining the studio locations
 *
 * @author Adeola
 */
package fitnessdb;

public enum Location {
    BRIDGEWATER("08807", "SOMERSET"),
    EDISON("08837", "MIDDLESEX"),
    FRANKLIN("08873", "SOMERSET"),
    PISCATAWAY("08854", "MIDDLESEX"),
    SOMERVILLE("08876", "SOMERSET");

    private final String zipCode;
    private final String county;

    Location(String zipcode, String county) {
        this.zipCode = zipcode;
        this.county = county;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getCounty() {
        return this.county;
    }

    public static Location getLocation(String name){
        if (name.toUpperCase().equals(BRIDGEWATER.name())){
            return BRIDGEWATER;
        }
        else if (name.toUpperCase().equals(EDISON.name())){
            return EDISON;
        }
        else if (name.toUpperCase().equals(FRANKLIN.name())){
            return FRANKLIN;
        }
        else if (name.toUpperCase().equals(PISCATAWAY.name())){
            return PISCATAWAY;
        }
        else if (name.toUpperCase().equals(SOMERVILLE.name())){
            return SOMERVILLE;
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        return this.name() + ", " + this.zipCode + ", " + this.county;
    }
}

