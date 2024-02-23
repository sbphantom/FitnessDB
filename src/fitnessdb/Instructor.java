package fitnessdb;
/**
 * @author Adeola
 */
public enum Instructor {
    JENNIFER,
    KIM,
    DENISE,
    DAVIS,
    EMMA;

    public static Instructor getInstructor(String name){
        if (name.toUpperCase().equals(JENNIFER.name())){
            return JENNIFER;
        }
        else if (name.toUpperCase().equals(KIM.name())){
           return KIM;
        }
        else if (name.toUpperCase().equals(DENISE.name())){
            return DENISE;
        }
        else if (name.toUpperCase().equals(DAVIS.name())){
            return DAVIS;
        }
        else if (name.toUpperCase().equals(EMMA.name())){
            return EMMA;
        }
        else{
            return null;
        }
    }
}
