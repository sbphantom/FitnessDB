package fitnessdb;
/**
 * @author Adeola
 */
public class Basic extends Member{
    private  int numClasses;
    private final double BASICPRICE = 39.99; 
    private double amount;
    public Basic(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        this.numClasses = 0;
    }

    @Override
    public double bill() {       
        this.amount +=BASICPRICE;
        return this.amount;
    }

    public int  getNumClasses(){
        return this.numClasses; 
    }

    public void setNumClasses(int numClasses){
        this.numClasses = numClasses; 
    }

}
