package fitnessdb;

import java.util.Calendar;

/**
 * @author Adeola
 */
public class Family extends Member{

    private boolean guest;
    private final double FAMILYPRICE = 49.99; 
   
    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        this.guest = !expire.isExpired();

    }

    @Override
    public double bill() {
        return FAMILYPRICE; 
    }

    public boolean getGuest(){
        return this.guest; 
    }

    public void setGuest(boolean guest){
        this.guest = guest; 
    }
}
