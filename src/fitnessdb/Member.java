package fitnessdb;

import static fitnessdb.Location.EDISON;

public class Member implements Comparable<Member> {
    private Profile profile;
    private Date expire;
    private Location homeStudio;
    
    public Member(Profile profile, Date expire, Location homeStudio){
        this.profile = profile; 
        this.expire = expire; 
        this.homeStudio = homeStudio; 
    }
    
    
    public double bill() {
        return 0.0; 
     } //return the next due amount

    @Override
    public int compareTo(Member member) {
        if(this.profile.compareTo( member.profile) !=0){
            return this.profile.compareTo( member.profile);
        } else if (this.expire.compareTo(member.expire) !=0) {
            return this.expire.compareTo(member.expire);
        }
        else return this.homeStudio.compareTo(member.homeStudio);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member member){
            return this.profile.equals(member.profile) && this.expire.equals(member.expire) && this.homeStudio.equals(member.homeStudio);
        }
        return false;
    }

    @Override
    public String toString() {
        String location = "";
        location =  String.format("%s, %s, %s", homeStudio.name(), homeStudio.getZipCode(), homeStudio.getCounty()); 
        return String.format("%s, Membership expires %s, Location: %s", this.profile.toString(), this.expire.toString(), location);
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Location getHomeStudio() {
        return homeStudio;
    }

    public void setHomeStudio(Location homeStudio) {
        this.homeStudio = homeStudio;
    }

    //TestBed
    public static void main(String[] args) {

        Member basicMember = new Basic(new Profile("Kate", "Lindsey", new Date(1989, 12, 1 )), new Date ( 2024, 5, 31), Location.FRANKLIN);
        Member basicMember2 = new Basic(new Profile("William", "Black", new Date(2003, 6, 2 )), new Date ( 2024, 5, 31), Location.PISCATAWAY);

        Member familyMember = new Family(new Profile("Carl", "Brown", new Date(1991, 10, 7 )), new Date ( 2024, 3, 31), Location.PISCATAWAY);
        Member premuimMember = new Premium(new Profile("Saul", "Goodman", new Date(1999, 5, 1)), new Date ( 2024, 1, 25), Location.BRIDGEWATER);

        System.out.println(basicMember.equals(basicMember2)); //False

    }
}