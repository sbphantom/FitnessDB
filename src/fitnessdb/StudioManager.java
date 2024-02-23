package fitnessdb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class StudioManager {
    private MemberList memberlist = new MemberList();

    private Schedule schedule = new Schedule();
    private final Date CURRENTDate = Date.todayDate();


    /* Command list
   AB - Add basic member (AB April March 3/31/1990 Piscataway)
   AF - Add family member
   AP - Add premium member
   C - Cancel/remove member (C Paul Siegel 5/1/1999)
   S - Display class schedule with current attendees
   PM - Print members sorted by member profiles (last name -> first name -> dob)
   PC = Print members sorted by county names, then zip code
   PF - Print members with membership fees
   R - Record attendance (R cardio Jennifer somerville Roy Brooks 12/8/1977)
   U - remove a member from a class (U Pilates Mary Lindsey 12/1/1989)
   RG - Record guest attendance (RG cardio Davis bridgewater Jonnathan Wei 9/21/1992)
   UG - Remove guest attendance (UG pilates davis Edison Jerry Brown 6/30/1979)
   Q - Stop program
    */
    //AB John Doe 1/20/2003 BRIDGEWATER
    private String commandAB(String[] response) {
        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }        Location location = Location.getLocation(response[4]);
        Profile profile = new Profile(fname, lname, dob);

        if (!dob.isValid()) {
            return String.format("DOB %s: invalid calendar date!", dob);
        } else if (dob.compareTo(Date.todayDate()) >= 0) {
            return String.format("DOB %s: cannot be today or a future date!", dob);
        } else if (profile.isMinor()) {
            return String.format("DOB %s: must be 18 or older to join!", dob);
        }
        if (location == null) {
            return String.format("%s: invalid studio location!", response[4]);
        }

        Basic member = new Basic(profile, Date.todayDate().addMonths(1), location);

        if (memberlist.add(member)) {
            return String.format("%s %s added.", fname, lname);
        } else
            return String.format("%s %s is already in the member database.", fname, lname);
    }

    //AF Jerry Brown 6/30/2007 Edison
    private String commandAF(String[] response) {
        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }        Location location = Location.getLocation(response[4]);
        Profile profile = new Profile(fname, lname, dob);

        if (!dob.isValid()) {
            return String.format("DOB %s: invalid calendar date!", dob);
        } else if (dob.compareTo(Date.todayDate()) >= 0) {
            return String.format("DOB %s: cannot be today or a future date!", dob);
        } else if (profile.isMinor()) {
            return String.format("DOB %s: must be 18 or older to join!", dob);
        }
        if (location == null) {
            return String.format("%s invalid studio location!", response[4]);
        }

        Family member = new Family(profile, Date.todayDate().addMonths(3), location);

        if (memberlist.add(member)) {
            return String.format("%s %s added.", fname, lname);
        } else
            return String.format("%s %s is already in the member database.", fname, lname);
    }

    //AP Jonnathan Wei 9/21/2006 bridgewater
    private String commandAP(String[] response) {
        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }        Location location = Location.getLocation(response[4]);
        Profile profile = new Profile(fname, lname, dob);

        if (!dob.isValid()) {
            return String.format("DOB %s: invalid calendar date!", dob);
        } else if (dob.compareTo(Date.todayDate()) >= 0) {
            return String.format("DOB %s: cannot be today or a future date!", dob);
        } else if (profile.isMinor()) {
            return String.format("DOB %s: must be 18 or older to join!", dob);
        }
        if (location == null) {
            return String.format("%s invalid studio location!", response[4]);
        }

        Premium member = new Premium(profile, Date.todayDate().addYears(1), location);

        if (memberlist.add(member)) {
            return String.format("%s %s added.", fname, lname);
        } else
            return String.format("%s %s is already in the member database.", fname, lname);
    }

    //C Bill Scanlan 5/1/1999
    private String commandC(String[] response) {

        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }
        Profile profile = new Profile(fname, lname, dob);

        Member member = new Member(profile);

        if (memberlist.remove(member)) {
            return String.format("%s %s removed.", fname, lname);
        } else
            return String.format("%s %s is not in the member database.", fname, lname);
    }

    //S
    private String commandS() {
        return null;
    }

    //PM
    private String commandPM() {
        return null;
    }

    //PC
    private String commandPC() {
        return null;
    }

    //PF
    private String commandPF() {
        return null;
    }

    //R cardio Jennifer somerville Roy Brooks 8/8/1977
    private String commandR(String input) {
        return null;
    }

    //U Pilates KIM FRANKLIN Mary Lindsey 12/1/1989
    private String commandU(String input) {
        return null;
    }

    //RG Pilates Jennifer Bridgewater Mary Lindsey 12/1/1989
    private String commandRG(String input) {
        return null;
    }

    //UG pilates davis Edison Jerry Brown 6/30/1979
    private String commandUG(String input) {
        return null;
    }

    private String commandHandler(String inputString) {
        String[] request = inputString.split(" ");
        String command = request[0];
        return switch (command) {
            case "AB" -> {
                if (request.length == 5) {
                    yield commandAB(request);
                } else yield "Missing data tokens.";
            }
            case "AF" -> {
                if (request.length == 5) {
                    yield commandAF(request);
                } else yield "Missing data tokens.";
            }
            case "AP" -> {
                if (request.length == 5) {
                    yield commandAP(request);
                } else yield "Missing data tokens.";
            }
            case "C" -> {
                if (request.length == 4) {
                    yield commandC(request);
                } else yield "Missing data tokens.";
            }
            case "S" -> commandS();
            case "PM" -> commandPM();
            case "PC" -> commandPC();
            case "PF" -> commandPF();
            case "R" -> commandR(inputString);
            case "U" -> commandU(inputString);
            case "RG" -> commandRG(inputString);
            case "UG" -> commandUG(inputString);
//            case "PD" -> {
//                if (mainCollection.isEmpty()) yield "Collection is empty!";
//                else {
//                    mainCollection.printByDate();
//                    yield printCollection("PD", mainCollection);
//                }
//            }

            default -> String.format("%s is an invalid command!", command);
        };
    }

    private void loadMembers(File file) {
        try {
            memberlist.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("-list of members loaded-");
            for (Member m : memberlist.getMembers()) {
                if (m != null) System.out.println(m);
            }
            System.out.println("-end of list-\n\n");
        }
    }

    private void loadSchedule(File file) {
        try {
            schedule.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("-Fitness classes loaded-");
            for (FitnessClass f : schedule.getClasses()) {
                if (f != null) System.out.println(f);
            }
            System.out.println("-end of class list.\n");
        }
    }

    public void run() {
        loadMembers(new File("data/memberList.txt"));
        loadSchedule(new File("data/classSchedule.txt"));

        System.out.println("Studio Manager is up running...\n");
        Scanner input = new Scanner(System.in);
        MemberList memberlist = new MemberList();
        while (input.hasNext()) {

            String line = input.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }

            if (line.equals("Q")) {
                System.out.println("Studio Manager terminated.");
                input.close();
                break;
            }

            System.out.println(commandHandler(line));

        }
    }
}
