package fitnessdb;

import static fitnessdb.Location.EDISON;

public class Member implements Comparable<Member> {
    private Profile profile;
    private Date expire;
    private Location homeStudio;
    public double bill() { } //return the next due amount

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
        switch (homeStudio){
            case EDISON: location = "Edison, 08837, Middlesex County";
            case BRIDGEWATER: location = "Bridgewater, 08807, Somerset County";
            case SOMERVILLE: location = "Somerville, 08876, Somerset County";
            case FRANKLIN: location = "Franklin, 08873, Somerset County";
            case PISCATAWAY: location = "Piscataway, 08854, Middlesex County";
        }
        return String.format("%s, Membership expires %s, Location: %s", this.profile.toString(), this.expire.toString(), location);
    }


}