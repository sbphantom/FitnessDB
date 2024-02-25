package fitnessdb;

import java.util.Calendar;

/**
 * @author Adeola
 */
public class Family extends Member {

    private boolean guest;
    private final double FAMILY_PRICE = 49.99;

    private final int billingCycleLength = 3;

    public Family(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        this.guest = !expire.isExpired();

    }

    @Override
    public double bill() {
        double bill = FAMILY_PRICE * billingCycleLength;
        return bill;
    }


    @Override
    public boolean canGuest() {
        return !isExpired() && guest;
    }
    @Override
    public boolean useGuestPass() {
        if (canGuest()){
            guest = false;
            return true;
        }
        return false;
    }
    @Override
    public boolean addGuestPass() {
        guest = true;
        return true;
    }

    public boolean getGuest() {
        return this.guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        if (isExpired()) {
            return String.format("%s, Membership expired %s, Home Studio: %s, (Family) guest-pass remaining: not eligible", getProfile(), getExpire(), getHomeStudio());
        } else if (guest) {
            return String.format("%s, Membership expires %s, Home Studio: %s, (Family) guest-pass remaining: 1", getProfile(), getExpire(), getHomeStudio());
        } else {
            return String.format("%s, Membership expires %s, Home Studio: %s, (Family) guest-pass remaining: 0", getProfile(), getExpire(), getHomeStudio());
        }
    }

}
