package fitnessdb;

public class MemberList {
    private Member [] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array

    public static final int NOT_FOUND = -1;
    private int find(Member member) {
        for(int i = 0; i < members.length; i++){
            if(members[i].equals(member)){
                return i;
            }
        }
        return NOT_FOUND;
    }
    private void grow() { }
    public boolean contains(Member member) { }
    public boolean add(Member member) { }
    public boolean remove(Member member) { }
    public void load(File file) throws IOException { }//from the text file
    public void printByCounty() { } //sort by county then zip code
    public void printByMember() { } //sort by member profile
}