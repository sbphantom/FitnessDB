package fitnessdb;

/**
 * @author Adeola
 */
public class Profile implements Comparable<Profile> {
    private final String fname;
    private final String lname;
    private final Date dob;

    private final Member member = null;

    public boolean isMinor() {
        return isMinor;
    }

    private boolean isMinor;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Date getDob() {
        return dob;
    }

    public Profile(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;

        Date dateOfMajor = dob.addYears(18);

        if (dateOfMajor.getYear() < Date.todayDate().getYear() ||
                (dateOfMajor.getYear() == Date.todayDate().getYear() && dateOfMajor.getMonth() <= Date.todayDate().getMonth())) {
            this.isMinor = false;
        } else {
            this.isMinor = true;
        }
    }


    @Override
    public int compareTo(Profile profile) {
        if (this.lname.compareTo(profile.lname) != 0) {
            return this.lname.compareTo(profile.lname);
        } else if (this.fname.compareTo(profile.fname) != 0) {
            return this.fname.compareTo(profile.fname);
        } else return this.dob.compareTo(profile.dob);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile profile) {
            return this.fname.equalsIgnoreCase(profile.fname) && this.lname.equalsIgnoreCase(profile.lname);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.fname, this.lname, this.dob);
    }

    public static void main(String[] args) {

    }

}
