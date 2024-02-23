package fitnessdb;

/**
 * @author Adeola
 */
public class Profile implements Comparable<Profile>{
    private final String fname;
    private final String lname;
    private final Date dob;

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

    public Profile(String fname, String lname, Date dob){
        this.fname =fname; 
        this.lname = lname; 
        this.dob = dob;

        Date dateOfMajor = dob.addYears(18);
        System.out.println(dob + " : " + dateOfMajor);

        System.out.println(dob + " : " + dateOfMajor);

        if (dateOfMajor.getYear()-Date.todayDate().getYear() <= 0 || dateOfMajor.getMonth()-Date.todayDate().getMonth() <= 0){
            this.isMinor = false;
        }
        else{
            System.out.println(dob + " : " + dateOfMajor);
            System.out.println(dob + " : " + dateOfMajor);
            System.out.println(dateOfMajor.getYear()-Date.todayDate().getYear());
            System.out.println(dateOfMajor.getMonth()-Date.todayDate().getMonth());
            this.isMinor = true;
        }
    }


    @Override
    public int compareTo(Profile profile) {
        if (this.fname.compareTo(profile.fname) != 0) {
            return this.fname.compareTo(profile.fname);
        } else if(this.lname.compareTo(profile.lname) != 0){
            return this.lname.compareTo(profile.lname);
        }
        else return this.dob.compareTo(profile.dob);
    }

    @Override
    public boolean equals(Object obj) {
    if(obj instanceof Profile profile){
        return this.fname.equalsIgnoreCase(profile.fname) && this.lname.equalsIgnoreCase(profile.lname);
    }
    return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.fname, this.lname,this.dob);
    }

    public static void main(String[] args){

    }

}
