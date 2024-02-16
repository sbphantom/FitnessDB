package fitnessdb;

/**
 * @author Adeola
 */
public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;

    public Profile(String fname, String lname, Date dob){
        this.fname =fname; 
        this.lname = lname; 
        this.dob = dob; 
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
        return this.fname.equals(profile.fname) && this.lname.equals(profile.lname) && this.dob.equals(profile.dob) ;
    }
    return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.fname, this.lname,this.dob);
    }

}
