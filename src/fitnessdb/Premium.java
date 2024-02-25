package fitnessdb;

/**
 * @author Adeola
 */
public class Premium extends Member {
    private int guestPass;
    private final double PREMIUM_PRICE = 59.99;
    private final int billingCycleLength = 12;

    private final int complemntaryMonth = 1;


    public Premium(Profile profile, Date expire, Location homeStudio) {
        super(profile, expire, homeStudio);
        //TODO Auto-generated constructor stub
        if (expire.isExpired()) {
            this.guestPass = 0;
        } else {
            this.guestPass = 3;
        }

    }

    @Override
    public double bill() {
        return PREMIUM_PRICE * (billingCycleLength - complemntaryMonth);
    }

    @Override
    public boolean canGuest() {
        return (!isExpired() && guestPass > 0);
    }

    @Override
    public boolean useGuestPass() {
        if (canGuest()) {
            guestPass--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addGuestPass() {
        guestPass++;
        return true;
    }

    public int getGuessPass() {
        return guestPass;
    }

    public void setGuestPass(int guestPass) {
        this.guestPass = guestPass;
    }

    @Override
    public String toString() {
        if (isExpired()) {
            return String.format("%s, Membership expired %s, Home Studio: %s, (Premium) guest-pass remaining: not eligible", getProfile(), getExpire(), getHomeStudio());
        } else {
            return String.format("%s, Membership expires %s, Home Studio: %s, (Premium) guest-pass remaining: %d", getProfile(), getExpire(), getHomeStudio(), guestPass);
        }
    }

}
