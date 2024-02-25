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

    public FitnessClass(Offer classInfo, Instructor instructor, Location studio, Time time) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;
        this.time = time;

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

    public void addMember(Member member){
        members.add(member);
    }

    public void addGuest(Member guest){
        guests.add(guest);
    }
    public MemberList getMembers(){
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
    
    @Override
    public String toString(){
        return String.format("%s - %s, %d:%02d, %s", classInfo, instructor, time.getHour(),time.getMinute(), studio.name());
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
