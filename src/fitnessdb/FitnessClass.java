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
    public MemberList getMembers(){
        return members;
    }

    public Offer getOffer() {
        return classInfo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Location getStudio() {
        return studio;
    }

    public Time getTime() {
        return time;
    }

    public MemberList getGuests() {
        return guests;
    }

    public static void main(String[] args) {
    Offer offer = Offer.PILATES; 
    Instructor instructor = Instructor.EMMA; 
    Location studio = Location.PISCATAWAY; 
    Time time = Time.MORNING;
    Member member1 = new Basic(new Profile("Adeola", "Asimolowo", new Date(2003, 5 , 8)), new Date(2025, 8, 25), Location.SOMERVILLE);

    
    FitnessClass classOne = new FitnessClass(offer, instructor, studio, time);
    classOne.addMember(member1);
    System.out.println(classOne.getMembers());
}

}
