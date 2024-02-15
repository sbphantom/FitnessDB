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


}