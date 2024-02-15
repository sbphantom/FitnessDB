package fitnessdb;
/**
 *
 * @author Adeola
 */
public class Premium extends Member {
    private  int guestPass;
    private final double PREMIUMPRICE = 59.99; 

    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
    }

    @Override
    public double bill() {
        return PREMIUMPRICE;
    }


    public int getGuessPass(){
        return guestPass; 
    }

    public void setGuestPass(int guestPass){
        this.guestPass = guestPass; 
    }
}
