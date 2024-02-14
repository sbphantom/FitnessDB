package fitnessdb;

/**
 * @author Adeola
 */
public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;

    @Override
    public int compareTo() {

    }

    @Override
    public boolean equals(Object obj) {
    if(obj instanceof Profile profile){
        return this.fname.equals(profile.fname) && this.lname.equals(profile.lname) && this.dob.equals(profile.dob) ;
    }
    return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.fname, this.lname,this.dob);
    }

}
