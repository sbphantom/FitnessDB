package fitnessdb;

import java.io.File;
import java.io.IOException;

public class FitnessClass {
    private Offer classInfo;
    private Instructor instructor;
    private Location studio;
    private Time time;
    private MemberList members;
    private MemberList guests;

    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time, MemberList members, MemberList guests) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
        this.members = members;
        this.guests = guests;
    }


    public Offer getOffer() {
        return classInfo;
    }

    public void setOffer(Offer classInfo) {
        this.classInfo = classInfo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Location getStudio() {
        return studio;
    }

    public void setStudio(Location studio) {
        this.studio = studio;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public MemberList getMembers() {
        return members;
    }

    public void setMembers(MemberList members) {
        this.members = members;
    }

    public MemberList getGuests() {
        return guests;
    }

    public void setGuests(MemberList guests) {
        this.guests = guests;
    }
    
    
public static void main(String[] args) {
    Offer offer = Offer.PILATES; 
    Instructor instructor = Instructor.EMMA; 
    Location studio = Location.PISCATAWAY; 
    Time time = Time.MORNING; 
    MemberList m1 = new MemberList(); 
    try {
        m1.load(new File("src//fitnessdb//memberList.txt"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    FitnessClass classOne = new FitnessClass(offer, instructor, studio, time, m1, null); 

}

}
