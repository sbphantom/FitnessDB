package fitnessdb;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

/**
 * This is an array-based implementation of a linear data structure to hold a list of member
 * objects.
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
        if (size >= 0) System.arraycopy(members, 0, newArray, 0, size);
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

    /**
     * Sorts the collection based on a given parameter
     *
     * @param sortBy sorts collection by given string
     *               options are "release", "genre", and "rating"
     *               defaults to album title
     */
    private void sort(String sortBy) {
        for (int i = 1; i < size; ++i) {
            Member key = members[i];
            int j = i - 1;

            while (j >= 0 && compareMember(members[j], key, sortBy) > 0) {
                members[j + 1] = members[j];
                j = j - 1;
            }
            members[j + 1] = key;
        }
    }


    /**
     * Compares two albums based on a given param
     *
     * @param m1        first member to compare to
     * @param m2        second member to compare against
     * @param compareBy what to compare by
     *                  options are "county", "member", and "fees"
     *                  defaults to album title
     */
    private double compareMember(Member m1, Member m2, String compareBy) {
        return switch (compareBy) {
            case "county" -> {
                if (m1.getHomeStudio().getCounty().compareTo(m2.getHomeStudio().getCounty())  == 0) {
                    yield  m1.getHomeStudio().getZipCode().compareTo(m2.getHomeStudio().getZipCode());
                } else {
                    yield m1.getHomeStudio().getCounty().compareTo(m2.getHomeStudio().getCounty());
                }
            }
            case "member" -> m1.getProfile().compareTo(m2.getProfile());

            default -> 0.0;
        };
    }


    public void load(File file) throws IOException {
        Scanner scanner = null;
        boolean complete = false;
        try {
            scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                if(line.trim().isEmpty()){ break; }
                this.members[index] = parseMember(line);
                this.size++;
                index++;
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }//from the text file

    public int getSize(){return  this.size;}

    private Member parseMember(String line) {
        // Implement parsing logic here based on your file format
        // For example, split the line by a delimiter and extract relevant information
        String[] parts = line.split("\\s+");

        String memberType = parts[0];
        String fname = parts[1];
        String lname = parts[2];
        Date dob = dateBuilder(parts[3].split("/"));
        Date expire = dateBuilder(parts[4].split("/"));
        Location homestudio = Location.valueOf(parts[5]);

        Profile profile = new Profile(fname, lname, dob);
        return switch (memberType) {
            case "B" -> new Basic(profile, expire, homestudio);
            case "F" -> new Family(profile, expire, homestudio);
            case "P" -> new Premium(profile, expire, homestudio);
            default -> null;
        };

    }
    private Date dateBuilder(String[] dateEntry) {
        int[] result = new int[dateEntry.length];
        for (int i = 0; i < dateEntry.length; i++) {
            result[i] = Integer.parseInt(dateEntry[i]);
        }
        return new Date(result[2], result[0], result[1]);
    }


    //sort by county then zip code
    public void printByCounty() {
        sort("county");
        StringBuilder sb = new StringBuilder();
        sb.append("\"-list of members sorted by county/zipcode-\n");

        for (int i = 0; i < size; i++) {
            sb.append(members[i]).append("\n");
        }
        sb.append("* end of list *");
        System.out.println(sb);
    }

    //sort by member profile
    public void printByMember() {
        sort("member");
        StringBuilder sb = new StringBuilder();
        sb.append("-list of members sorted by member profiles-\n");

        for (int i = 0; i < size; i++) {
            sb.append(members[i]).append("\n");
        }
        sb.append("* end of list *");
        System.out.println(sb);
    }
    public void printByFees() {} //print the array as is with the next due amounts
}