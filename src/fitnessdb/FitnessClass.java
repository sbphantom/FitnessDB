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

    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void addGuest(Member guest){
        guests.add(guest);
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
