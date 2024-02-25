package fitnessdb;
/**
 * @author Adeola
 */
public class Basic extends Member{
    private int numClasses;
    private final double BASIC_PRICE = 39.99;

    private final int CLASS_LIMIT = 4;
    private final double EXTRA_CLASS_FEE = 10;
    
    public Basic(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        this.numClasses = 0;
    }

    @Override
    public double bill() {
        double bill = BASIC_PRICE;

        if (numClasses > CLASS_LIMIT){
            bill += ((numClasses - CLASS_LIMIT) * EXTRA_CLASS_FEE);
        }

        return bill;

    }

    public int getNumClasses(){
        return this.numClasses; 
    }

    public void incrementClassCount(){
        this.numClasses +=1 ;
    }

    @Override
    public String toString() {
        return String.format("%s, Membership expires %s, Home Studio: %s, (Basic) number of classes attended: %d", getProfile(), getExpire(), getHomeStudio(), numClasses);
    }

}
