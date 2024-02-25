package fitnessdb;
/**
 * @author Adeola
 */
public enum Offer {
    PILATES,
    SPINNING,
    CARDIO;

    public static Offer getOffer(String name){
        if (name.toUpperCase().equals(PILATES.name())){
            return PILATES;
        }
        else if (name.toUpperCase().equals(SPINNING.name())){
            return SPINNING;
        }
        else if (name.toUpperCase().equals(CARDIO.name())){
            return CARDIO;
        }
        else{
            return null;
        }
    }

}
