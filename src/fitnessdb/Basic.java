package fitnessdb;
/**
 * @author Adeola
 */
public class Basic extends Member{
    private int numClasses;
    private final double BASICPRICE = 39.99; 
    
    public Basic(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        this.numClasses = 0;
    }

    @Override
    public double bill() {       
        return BASICPRICE;  
    }

    public int  getNumClasses(){
        return this.numClasses; 
    }

    public void setNumClasses(int numClasses){
        this.numClasses = numClasses; 
    }

    @Override
    public String toString() {
        return String.format("%s, Membership expires %s, Home Studio: %s, (Basic) number of classes attended: %d", this.getProfile(), this.getExpire(), this.getHomeStudio(), this.attendanceCount());
    }

}
