package fitnessdb;

public class Member implements Comparable<Member> {
    private Profile profile;
    private Date expire;
    private Location homeStudio;
    public double bill() { } //return the next due amount

    @Override
    public int compareTo() {

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
        return String.format("%s, Membership expires %s, Location:", this.profile.toString(), this.expire.toString());
    }


}