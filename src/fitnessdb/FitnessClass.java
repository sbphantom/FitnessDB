package fitnessdb;

import java.io.File;
import java.io.IOException;

public class FitnessClass {
    private Offer classInfo;
    private Instructor instructor;
    private Location studio;
    private Time time;
    private MemberList members = new MemberList();
    private MemberList guests = new MemberList();

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

    public FitnessClass(Offer classInfo, Instructor instructor, Location studio) {
        this.classInfo = classInfo;
        this.instructor = instructor;
        this.studio = studio;

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

    public void addMember(Member member) {
        members.add(member);
    }

    public void addGuest(Member guest) {
        guests.add(guest);
    }

    public MemberList getMembers() {
        return members;
    }

    public boolean removeMember(Member member){
        return members.remove(member);
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
    public String toString() {
        return String.format("%s, %d:%02d, %s", instructor, time.getHour(), time.getMinute(), studio.name());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FitnessClass c) {
            return this.studio.equals(c.studio) && this.instructor.equals(c.instructor) && this.classInfo.equals(c.classInfo);
        }
        return false;
    }

    public static void main(String[] args) {
        Offer offer = Offer.PILATES;
        Instructor instructor = Instructor.EMMA;
        Location studio = Location.PISCATAWAY;
        Time time = Time.MORNING;
        Member member1 = new Basic(new Profile("Adeola", "Asimolowo", new Date(2003, 5, 8)), new Date(2025, 8, 25), Location.SOMERVILLE);


        FitnessClass classOne = new FitnessClass(offer, instructor, studio, time);
        classOne.addMember(member1);
        System.out.println(classOne.getMembers());
    }

    public boolean hasAttendance() {
        return members.getSize() > 0;
    }

    public String attendanceList() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s\n", classInfo, toString()));
        if (hasAttendance())
            sb.append("[Attendees]\n");{
            for (int i = 0; i < members.getSize(); i++) {
                sb.append("   "+ members.getMembers()[i] +"\n");
            }
        }

        return sb.toString();
    }
}
