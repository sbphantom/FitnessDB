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
//        String[] response = input.split(" ");
        String fname = response[1];
        String lname = response[2];
        Date dob = new Date(response[3]);
        Location location = Location.getLocation(response[4]);


        Profile profile = new Profile(fname, lname, dob);
        Basic member = new Basic(profile, Date.todayDate().addMonths(3), location);
        memberlist.add(member);

        return null;
    }

    //AF Jerry Brown 6/30/2007 Edison
    private String commandAF(String input) {

        return null;
    }

    //AP Jonnathan Wei 9/21/2006 bridgewater
    private String commandAP(String input) {
        return null;
    }

    //C Bill Scanlan 5/1/1999
    private String commandC(String input) {
        return null;
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
                if (request.length == 3) {
                    yield commandAB(request);
                }
                else yield null;
            }
            case "AF" -> commandAF(inputString);
            case "AP" -> commandAP(inputString);
            case "C" -> commandC(inputString);
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
