package fitnessdb;

import java.io.File;
import java.io.IOException;

/**
 * @author Adeola Asimolowo, Danny Onurah
 */
public class MemberList {
    private Member [] members; //holds Basic, Family, or Premium objects
    private int size; //number of objects in the array
    public static final int NOT_FOUND = -1;
    public static final int PARTITION_SIZE = 4;

    private int find(Member member) {
        for(int i = 0; i < members.length; i++){
            if(members[i].equals(member)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Member[] newArray = new Member[size + PARTITION_SIZE];
        for (int i = 0; i < size; i++) {
            newArray[i] = members[i];
        }
        members = newArray;

    }

    public boolean contains(Member member) { return find(member) != NOT_FOUND; }

    public boolean add(Member member) {
        if (contains(member)) return false;
        else {
            if (size % PARTITION_SIZE == 0) grow();
            members[size] = member;
            size++;
            return true;
        }
    }

    public boolean remove(Member member) {
        if (size == 0 || !contains(member)) return false;

        int index = find(member);
        if (index == size - 1) {
            members[index] = null;
        } else {
            for (int i = index; i < size - 1; i++) {
                members[i] = members[i + 1];
            }
            members[size - 1] = null;
        }
        size--;
        return true;
    }

    public void sort(String sortBy){
        
    }


    public void load(File file) throws IOException { }//from the text file
    public void printByCounty() { } //sort by county then zip code
    public void printByMember() { } //sort by member profile
    public void printByFees() {} //print the array as is with the next due amounts
}